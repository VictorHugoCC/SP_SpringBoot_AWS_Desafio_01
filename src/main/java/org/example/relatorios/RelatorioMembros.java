package org.example.relatorios;

import org.example.entidades.Membro;
import org.example.interfaces.Relatorio;
import org.example.servico.MembroService;
import org.example.util.JPAUtil;

import java.util.List;

public class RelatorioMembros implements Relatorio {

    private final MembroService membroService = JPAUtil.getMembroService();

    @Override
    public void gerarRelatorio() {
        List<Membro> membros = membroService.listarTodos();
        if (membros.isEmpty()) {
            System.out.println("Nenhum membro cadastrado.");
        } else {
            System.out.println("---- Relatório de Membros ----");
            membros.forEach(membro -> {
                System.out.println("ID: " + membro.getId_membro());
                System.out.println("Nome: " + membro.getNome());
                System.out.println("E-mail: " + membro.getEmail());
                System.out.println("Telefone: " + membro.getTelefone());
                System.out.println("Endereço: " + membro.getEndereco());
                System.out.println("-----------------------------");
            });
        }
    }
}

