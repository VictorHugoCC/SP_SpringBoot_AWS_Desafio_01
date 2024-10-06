package org.example.relatorios;

import org.example.entidades.Emprestimo;
import org.example.servico.EmprestimoService;
import org.example.util.JPAUtil;
import org.example.interfaces.Relatorio;

import java.util.List;

public class RelatorioEMAtrasados implements Relatorio {

    private final EmprestimoService emprestimoService;

    public RelatorioEMAtrasados() {
        this.emprestimoService = JPAUtil.getEmprestimoService();
    }

    @Override
    public void gerarRelatorio() {
        List<Emprestimo> emprestimosAtrasados = emprestimoService.listarEmprestimosAtrasados();

        if (emprestimosAtrasados.isEmpty()) {
            System.out.println("Nenhum empréstimo atrasado.");
        } else {
            System.out.println("----- Relatório de Empréstimos Atrasados -----");
            emprestimosAtrasados.forEach(emprestimo -> {
                System.out.println("ID: " + emprestimo.getId_emprestimo());
                System.out.println("Membro: " + emprestimo.getMembro().getNome());
                System.out.println("Livros: ");
                emprestimo.getLivros().forEach(livro ->
                        System.out.println(" - " + livro.getTitulo())
                );
                System.out.println("Data do Empréstimo: " + emprestimo.getDataEmprestimo());
                System.out.println("Data de Devolução: Não devolvido ainda.");


                long diasAtraso = emprestimoService.calcularDiasAtraso(emprestimo.getDataEmprestimo(), emprestimo.getDataDevolucao());
                System.out.println("Dias de Atraso: " + diasAtraso);
                System.out.println("Multa: " + emprestimo.getMulta());

                System.out.println("--------------------------------------------");
            });
        }
    }
}
