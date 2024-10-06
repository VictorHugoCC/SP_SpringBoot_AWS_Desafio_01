package org.example.UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {

    private final Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("\n---- MENU PRINCIPAL ----");
                System.out.println("1. CADASTRO DE LIVROS");
                System.out.println("2. CADASTRO DE AUTORES");
                System.out.println("3. CADASTRO DE MEMBROS");
                System.out.println("4. EMPRÉSTIMO DE LIVROS");
                System.out.println("5. DEVOLUÇÃO DE LIVROS");
                System.out.println("6. RELATÓRIOS");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1 -> cadastroLivros();
                    case 2 -> cadastroAutores();
                    case 3 -> cadastroMembros();
                    case 4 -> realizarEmprestimo();
                    case 5 -> devolverLivro();
                    case 6 -> relatorios();
                    case 0 -> {
                        System.out.println("Saindo...");
                        continuar = false;
                    }
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número válido.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }


    private void cadastroLivros() {
        try {
            LivroMenu livroMenu = new LivroMenu();
            livroMenu.exibirMenuLivro();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar livro: " + e.getMessage());
        }
    }


    private void cadastroAutores() {
        try {
            AutorMenu autorMenu = new AutorMenu();
            autorMenu.exibirMenuAutor();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar autor: " + e.getMessage());
        }
    }


    private void cadastroMembros() {
        try {
            MembroMenu membroMenu = new MembroMenu();
            membroMenu.exibirMenuMembro();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar membro: " + e.getMessage());
        }
    }


    private void realizarEmprestimo() {
        try {
            EmprestimoMenu emprestimoMenu = new EmprestimoMenu();
            emprestimoMenu.realizarEmprestimo();
        } catch (Exception e) {
            System.out.println("Erro ao realizar empréstimo: " + e.getMessage());
        }
    }


    private void devolverLivro() {
        try {
            EmprestimoMenu emprestimoMenu = new EmprestimoMenu();
            emprestimoMenu.devolverLivro();
        } catch (Exception e) {
            System.out.println("Erro ao devolver livro: " + e.getMessage());
        }
    }


    private void relatorios() {
        try {
            RelatoriosMenu relatoriosMenu = new RelatoriosMenu();
            relatoriosMenu.exibirMenuRelatorios();
        } catch (Exception e) {
            System.out.println("Erro ao gerar relatório: " + e.getMessage());
        }
    }
}
