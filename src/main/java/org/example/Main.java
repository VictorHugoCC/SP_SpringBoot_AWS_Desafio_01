package org.example;

import org.example.entidades.Membro;
import org.example.servico.MembroService;
import org.example.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // Criar um novo membro
        Membro m = new Membro("Denise", null, "777", "denyteste22@gmail.com", "patamares", new Date());

        EntityManager em = JPAUtil.getEntityManager();
        MembroService membroService = new MembroService(em);

        // Cadastrar o novo membro
//        membroService.cadastrarMembro(m);

        // Listar e exibir os membros
        membroService.exibirMembros();

        em.close();
    }
}
