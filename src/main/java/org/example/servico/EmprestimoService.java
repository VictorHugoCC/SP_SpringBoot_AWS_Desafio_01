package org.example.servico;

import org.example.entidades.Emprestimo;
import org.example.entidades.Livro;
import org.example.entidades.Membro;
import org.example.util.JPAUtil;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class EmprestimoService extends GenericService<Emprestimo> {
    private final EntityManager entityManager;

    public EmprestimoService(EntityManager entityManager) {
        super(entityManager, Emprestimo.class);
        this.entityManager = entityManager;
    }


    public void realizarEmprestimo(int idMembro, int idLivro, Date dataEmprestimo) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Membro membro = em.find(Membro.class, idMembro);
            Livro livro = em.find(Livro.class, idLivro);

            if (membro != null && livro != null) {
                if (livro.getQuantidade() > 0) {
                    Emprestimo novoEmprestimo = new Emprestimo();
                    novoEmprestimo.setMembro(membro);
                    novoEmprestimo.setLivros(List.of(livro));
                    novoEmprestimo.setDataEmprestimo(dataEmprestimo);

                    long diasAtraso = calcularDiasAtraso(dataEmprestimo, new Date());
                    if (diasAtraso > 5) {
                        novoEmprestimo.setEstado(Emprestimo.EstadoEmprestimo.ATRASADO);
                        BigDecimal multa = BigDecimal.valueOf(diasAtraso * 5.00);
                        novoEmprestimo.setMulta(multa);
                    } else {
                        novoEmprestimo.setEstado(Emprestimo.EstadoEmprestimo.ATIVO);
                        novoEmprestimo.setMulta(BigDecimal.ZERO);
                    }

                    livro.setQuantidade(livro.getQuantidade() - 1);
                    em.persist(novoEmprestimo);

                    em.getTransaction().commit();
                    System.out.println("Empréstimo realizado com sucesso!");
                } else {
                    System.out.println("Livro indisponível para empréstimo.");
                }
            } else {
                System.out.println("Membro ou Livro inválidos.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao realizar o empréstimo: " + e.getMessage());
        } finally {
            em.clear();
        }
    }
    public void concluirEmprestimo(int idEmprestimo, Date dataDevolucao) {
        Optional<Emprestimo> optionalEmprestimo = buscarPorId(idEmprestimo);
        EntityManager em = JPAUtil.getEntityManager();

        if (optionalEmprestimo.isPresent()) {
            Emprestimo emprestimo = optionalEmprestimo.get();
            emprestimo.setDataDevolucao(dataDevolucao);
            emprestimo.setEstado(Emprestimo.EstadoEmprestimo.CONCLUIDO);

            for (Livro livro : emprestimo.getLivros()) {
                livro.setQuantidade(livro.getQuantidade() + 1);
                em.merge(livro);
            }

            atualizar(emprestimo);
            System.out.println("Empréstimo concluído com sucesso!");
        } else {
            System.out.println("Empréstimo não encontrado.");
        }
    }



    public long calcularDiasAtraso(Date dataEmprestimo, Date dataDevolucao) {
        Date dataFinal = dataDevolucao != null ? dataDevolucao : new Date();
        long diff = dataFinal.getTime() - dataEmprestimo.getTime();
        return diff / (1000 * 60 * 60 * 24);
    }


    public List<Emprestimo> listarEmprestimosAtrasados() {
        String jpql = "SELECT e FROM Emprestimo e WHERE e.estado = :estado";
        return entityManager.createQuery(jpql, Emprestimo.class)
                .setParameter("estado", Emprestimo.EstadoEmprestimo.ATRASADO)
                .getResultList();
    }
}

