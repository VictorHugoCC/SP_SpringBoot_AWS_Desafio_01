package org.example.UI;
import org.example.util.InputUtil;
import org.example.util.JPAUtil;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
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
                case 6 -> relatorios();
                case 0 -> {
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

//    Corrigir posteriormente esse menu

    private void emprestimoLivros() {
        System.out.print("Digite o ID do Membro: ");
        int idMembro = scanner.nextInt();

        System.out.print("Digite o ID do Livro: ");
        int idLivro = scanner.nextInt();

        String dataEmprestimoStr = InputUtil.obterInputObrigatorio("Digite a data do empréstimo (formato yyyy-MM-dd): ");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dataEmprestimo;
        try {
            dataEmprestimo = format.parse(dataEmprestimoStr);
        } catch (Exception e) {
            System.out.println("Formato de data inválido. Use o formato yyyy-MM-dd.");
            return;
        }

        JPAUtil.getEmprestimoService().realizarEmprestimo(idMembro, idLivro, dataEmprestimo);
    }


    private void devolucaoLivros() {
        System.out.println("Opção de Devolução de Livros");

        int idEmprestimo = Integer.parseInt(InputUtil.obterInputObrigatorio("Digite o ID do Empréstimo: "));
        Date dataDevolucao = new Date();

        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();


            JPAUtil.getEmprestimoService().concluirEmprestimo(idEmprestimo, dataDevolucao);

            em.getTransaction().commit();
            System.out.println("Empréstimo concluído com sucesso!");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Erro ao atualizar Emprestimo: " + e.getMessage());
        } finally {
            em.close();
        }
    }


    private void relatorios() {
        System.out.println("Opção de Relatórios");
        JPAUtil.getEmprestimoService().listarEmprestimos();
    }
}
