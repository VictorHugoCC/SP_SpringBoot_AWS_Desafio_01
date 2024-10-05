package org.example.servico;


import org.example.entidades.Emprestimo;
import org.example.entidades.Livro;
import org.example.entidades.Membro;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmprestimoService extends GenericService<Emprestimo> {

    private EntityManager entityManager;

    public EmprestimoService(EntityManager entityManager) {
        super(entityManager, Emprestimo.class);
        this.entityManager = entityManager;
    }

    public void realizarEmprestimo(int idMembro, int idLivro, Date dataEmprestimo) {
        Membro membro = entityManager.find(Membro.class, idMembro);
        Livro livro = entityManager.find(Livro.class, idLivro);

        if (membro != null && livro != null) {
            if (livro.getQuantidade() > 0) {
                Emprestimo novoEmprestimo = new Emprestimo();
                novoEmprestimo.setMembro(membro);
                novoEmprestimo.setLivros(Collections.singletonList(livro));
                novoEmprestimo.setDataEmprestimo(dataEmprestimo);
                novoEmprestimo.setEstado(Emprestimo.EstadoEmprestimo.ATIVO);
                novoEmprestimo.setMulta(BigDecimal.ZERO);

                livro.setQuantidade(livro.getQuantidade() - 1);
                cadastrar(novoEmprestimo);

                System.out.println("Empréstimo realizado com sucesso!");
            } else {
                System.out.println("Livro indisponível para empréstimo.");
            }
        } else {
            System.out.println("Membro ou Livro inválidos.");
        }
    }


    public void listarEmprestimos() {
        List<Emprestimo> emprestimos = listarTodos();
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println("ID Empréstimo: " + emprestimo.getId_emprestimo());
            System.out.println("Membro: " + emprestimo.getMembro().getNome());
            System.out.println("Livros: " + emprestimo.getLivros().stream()
                    .map(Livro::getTitulo)
                    .collect(Collectors.joining(", ")));
            System.out.println("Data Empréstimo: " + emprestimo.getDataEmprestimo());
            System.out.println("Estado: " + emprestimo.getEstado());
            System.out.println("-----------------------------------");
        }
    }

    public void concluirEmprestimo(int idEmprestimo, Date dataDevolucao) {
        Optional<Emprestimo> optionalEmprestimo = buscarPorId(idEmprestimo);

        if (optionalEmprestimo.isPresent()) {
            Emprestimo emprestimo = optionalEmprestimo.get();
            emprestimo.setDataDevolucao(dataDevolucao);
            emprestimo.setEstado(Emprestimo.EstadoEmprestimo.CONCLUIDO);

            long diasAtraso = calcularDiasAtraso(emprestimo.getDataEmprestimo(), dataDevolucao);
            if (diasAtraso > 0) {
                BigDecimal multa = BigDecimal.valueOf(diasAtraso * 5.00); // Exemplo de R$5 por dia de atraso
                emprestimo.setMulta(multa);
            } else {
                emprestimo.setMulta(BigDecimal.ZERO);
            }

            atualizar(emprestimo);
            System.out.println("Empréstimo concluído com sucesso!");
        } else {
            System.out.println("Empréstimo não encontrado.");
        }

    }

    private long calcularDiasAtraso(Date dataEmprestimo, Date dataDevolucao) {
        long diferencaMillis = dataDevolucao.getTime() - dataEmprestimo.getTime();
        return diferencaMillis / (1000 * 60 * 60 * 24);
    }


}

