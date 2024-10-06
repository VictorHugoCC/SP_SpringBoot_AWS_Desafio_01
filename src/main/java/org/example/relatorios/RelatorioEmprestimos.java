package org.example.relatorios;

import org.example.entidades.Emprestimo;
import org.example.interfaces.Relatorio;
import org.example.servico.EmprestimoService;
import org.example.util.JPAUtil;

import java.util.Comparator;
import java.util.List;

public class RelatorioEmprestimos implements Relatorio {

    private final EmprestimoService emprestimoService = JPAUtil.getEmprestimoService();

    @Override
    public void gerarRelatorio() {
        List<Emprestimo> emprestimos = emprestimoService.listarTodos();

        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo cadastrado.");
        } else {
            System.out.println("---- Relatório de Empréstimos ----");
            emprestimos.stream()
                    .sorted(Comparator.comparing(Emprestimo::getDataEmprestimo))
                    .forEach(emprestimo -> {
                        System.out.println("ID Empréstimo: " + emprestimo.getId_emprestimo());
                        System.out.println("Membro (ID): " + emprestimo.getMembro().getId_membro() + ", Nome: " + emprestimo.getMembro().getNome());

                        System.out.println("Livros: ");
                        emprestimo.getLivros().stream()
                                .forEach(livro -> System.out.println(" - " + livro.getTitulo() + " (ID: " + livro.getIdLivro() + ")"));

                        System.out.println("Data do Empréstimo: " + emprestimo.getDataEmprestimo());
                        System.out.println("Estado: " + emprestimo.getEstado());
                        System.out.println("-----------------------------");
                    });
        }
    }
}
