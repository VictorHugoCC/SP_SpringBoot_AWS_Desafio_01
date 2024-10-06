package org.example.UI;

import org.example.entidades.Membro;
import org.example.servico.MembroService;
import org.example.util.InputUtil;
import org.example.util.JPAUtil;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MembroMenu {

    MembroService membroService = JPAUtil.getMembroService();
    private final Set<Membro> membrosUnicos = new HashSet<>();

    public void exibirMenuMembro() {
        try {
            System.out.println("---- Cadastro de Membros ----");
            String nome = InputUtil.obterInputObrigatorio("Nome do Membro: ");
            String telefone = InputUtil.obterInputNumericoValido("Telefone (apenas números): ");
            String email;

            do {
                email = InputUtil.obterInputObrigatorio("Email: ");
                if (membroService.buscarMembro(email) != null) {
                    System.out.println("E-mail já está cadastrado. Por favor, insira um e-mail diferente.");
                }
            } while (membroService.buscarMembro(email) != null);

            String endereco = InputUtil.obterInputObrigatorio("Endereço: ");
            Membro novoMembro = new Membro(nome, telefone, email, endereco, new Date());

            if (membrosUnicos.add(novoMembro)) {
                membroService.cadastrar(novoMembro);
                System.out.println("Membro cadastrado com sucesso!");
            } else {
                System.out.println("Membro já cadastrado no sistema.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar membro: " + e.getMessage());
        }
    }
}
