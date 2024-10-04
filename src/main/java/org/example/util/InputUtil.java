package org.example.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String obterInputObrigatorio(String mensagem) {
        String input = "";
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensagem);
                input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Este campo é obrigatório, por favor preencha.");
                }
                valido = true; // Se chegar até aqui, a entrada é válida
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Erro de entrada: tente novamente.");
                scanner.next(); // Limpa a entrada incorreta
            }
        }

        return input;
    }

    public static String obterInputNumericoValido(String mensagem) {
        String input = "";
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensagem);
                input = scanner.nextLine().trim();

                Long.parseLong(input);

                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Apenas numeros. Tente novamente.");
            }
        }

        return input;
    }


}
