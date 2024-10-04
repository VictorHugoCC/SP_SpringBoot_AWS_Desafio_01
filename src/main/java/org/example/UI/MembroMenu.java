package org.example.UI;

import org.example.entidades.Membro;
import org.example.servico.MembroService;
import org.example.util.InputUtil;
import org.example.util.JPAUtil;
import java.util.Date;

public class MembroMenu {

    MembroService membroService = JPAUtil.getMembroService();

    public void exibirMenuMembro() {
        System.out.println("---- Cadastro de Membros ----");

        String nome = InputUtil.obterInputObrigatorio("Nome do Membro: ");
        String telefone = InputUtil.obterInputObrigatorio("Telefone: ");
        String email = InputUtil.obterInputObrigatorio("Email: ");
        String endereco = InputUtil.obterInputObrigatorio("Endereço: ");

        Membro novoMembro = new Membro(nome, telefone, email, endereco, new Date());

        membroService.cadastrar(novoMembro);

    }

}
