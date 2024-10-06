package org.example.UI;

import org.example.util.InputUtil;
import org.example.util.JPAUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EmprestimoMenu {

    private final Scanner scanner = new Scanner(System.in);

    public void realizarEmprestimo() {
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

    public void devolverLivro() {
        int idEmprestimo = 0;
        boolean emprestimoValido = false;

        while (!emprestimoValido) {
            System.out.print("Digite o ID do Empréstimo: ");
            idEmprestimo = scanner.nextInt();

            if (JPAUtil.getEmprestimoService().buscarPorId(idEmprestimo).isPresent()) {
                emprestimoValido = true;
            } else {
                System.out.println("Empréstimo não encontrado. Tente novamente.");
            }
        }

        Date dataDevolucao = new Date();
        JPAUtil.getEmprestimoService().concluirEmprestimo(idEmprestimo, dataDevolucao);
    }

}
