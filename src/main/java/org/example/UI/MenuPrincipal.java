package org.example.UI;

import org.example.entidades.Membro;
import org.example.servico.MembroService;
import org.example.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.Scanner;

public class MenuPrincipal {

    private final Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n---- MENU PRINCIPAL ----");
            System.out.println("1. CADASTRO DE LIVROS");
            System.out.println("2. CADASTRO DE AUTORES");
            System.out.println("3. CADASTRO DE MEMBROS");
            System.out.println("4. EMPRÉSTIMO DE LIVROS");
            System.out.println("5. DEVOLUÇÃO DE LIVROS");
            System.out.println("6. MULTA POR ATRASO");
            System.out.println("7. RELATÓRIOS");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> cadastroLivros();
                case 2 -> cadastroAutores();
                case 3 -> cadastroMembros();
                case 4 -> emprestimoLivros();
                case 5 -> devolucaoLivros();
                case 6 -> multaPorAtraso();
                case 7 -> relatorios();
                case 8 -> {
                    System.out.println("Saindo...");
                    continuar = false;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void cadastroLivros() {
        LivroMenu livroMenu = new LivroMenu();
        livroMenu.exibirMenuLivro();
    }

    private void cadastroAutores() {
        AutorMenu autorMenu = new AutorMenu();
        autorMenu.exibirMenuAutor();
    }

    private void cadastroMembros() {
        MembroMenu membroMenu = new MembroMenu();
        membroMenu.exibirMenuMembro();
    }


    private void emprestimoLivros() {
        System.out.println("Opção de Empréstimo de Livros");
    }

    private void devolucaoLivros() {
        System.out.println("Opção de Devolução de Livros");
    }

    private void multaPorAtraso() {
        System.out.println("Opção de Multa por Atraso");
    }

    private void relatorios() {
        System.out.println("Opção de Relatórios");
    }
}
