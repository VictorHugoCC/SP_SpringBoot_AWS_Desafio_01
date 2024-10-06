package org.example.UI;

import org.example.relatorios.*;
import org.example.interfaces.Relatorio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RelatoriosMenu {

    private final Scanner scanner = new Scanner(System.in);

    public void exibirMenuRelatorios() {
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("\n---- MENU DE RELATÓRIOS ----");
                System.out.println("1. Relatório de Livros");
                System.out.println("2. Relatório de Membros");
                System.out.println("3. Relatório de Empréstimos");
                System.out.println("4. Relatório de Autores");
                System.out.println("5. Relatório de Empréstimos atrasados");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1 -> gerarRelatorio(new RelatorioLivros());
                    case 2 -> gerarRelatorio(new RelatorioMembros());
                    case 3 -> gerarRelatorio(new RelatorioEmprestimos());
                    case 4 -> gerarRelatorio(new RelatorioAutores());
                    case 5 -> gerarRelatorio(new RelatorioEMAtrasados());
                    case 0 -> {
                        System.out.println("Voltando ao menu principal...");
                        continuar = false;
                    }
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Digite um número para selecionar uma opção.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao gerar o relatório: " + e.getMessage());
            }
        }
    }


    private void gerarRelatorio(Relatorio relatorio) {
        try {
            relatorio.gerarRelatorio();
        } catch (Exception e) {
            System.out.println("Erro ao gerar o relatório: " + e.getMessage());
        }
    }
}
