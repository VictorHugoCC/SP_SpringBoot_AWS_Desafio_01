//package org.example.servico;
//
//import org.example.dao.Repositorio;
//import org.example.entidades.Emprestimo;
//import org.example.entidades.Livro;
//import org.example.entidades.Membro;
//
//import javax.persistence.EntityManager;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class EmprestimoService {
//
//    private Repositorio<Emprestimo> emprestimoRepositorio;
//    private Repositorio<Livro> livroRepositorio;
//    private Repositorio<Membro> membroRepositorio;
//
//    public EmprestimoService(EntityManager entityManager) {
//        this.emprestimoRepositorio = new Repositorio<>(entityManager, Emprestimo.class);
//        this.livroRepositorio = new Repositorio<>(entityManager, Livro.class);
//        this.membroRepositorio = new Repositorio<>(entityManager, Membro.class);
//    }
//
//    public void realizarEmprestimo(Long idLivro, Long idMembro) {
//        Livro livro = livroRepositorio.buscarPorId(idLivro);
//        Membro membro = membroRepositorio.buscarPorId(idMembro);
//
//        if (livro.getQuantidade() > 0 && membro != null) {
//            Emprestimo emprestimo = new Emprestimo(livro, membro, LocalDate.now(), null, EstadoEmprestimo.ATIVO, BigDecimal.ZERO);
//            emprestimoRepositorio.cadastrar(emprestimo);
//
//            livro.setQuantidade(livro.getQuantidade() - 1);
//            livroRepositorio.atualizar(livro);
//        } else {
//            System.out.println("Livro indisponível ou membro não encontrado.");
//        }
//    }
//
//    public void devolverLivro(Long idEmprestimo) {
//        Emprestimo emprestimo = emprestimoRepositorio.buscarPorId(idEmprestimo);
//
//        if (emprestimo != null && emprestimo.getEstado() == EstadoEmprestimo.ATIVO) {
//            LocalDate dataAtual = LocalDate.now();
//            emprestimo.setDataDevolucao(dataAtual);
//            emprestimo.setEstado(EstadoEmprestimo.CONCLUIDO);
//
//            long diasAtraso = dataAtual.toEpochDay() - emprestimo.getDataEmprestimo().toEpochDay();
//            if (diasAtraso > 7) {
//                BigDecimal multa = BigDecimal.valueOf((diasAtraso - 7) * 2.00);  // Exemplo: R$ 2,00 por dia de atraso
//                emprestimo.setMulta(multa);
//            }
//
//            emprestimoRepositorio.atualizar(emprestimo);
//
//            Livro livro = emprestimo.getLivro();
//            livro.setQuantidade(livro.getQuantidade() + 1);
//            livroRepositorio.atualizar(livro);
//        } else {
//            System.out.println("Empréstimo não encontrado ou já concluído.");
//        }
//    }
//
//    public List<Emprestimo> listarEmprestimosAtivos() {
//        return emprestimoRepositorio.listarTodos()
//                .stream()
//                .filter(e -> e.getEstado() == EstadoEmprestimo.ATIVO)
//                .collect(Collectors.toList());
//    }
//}
