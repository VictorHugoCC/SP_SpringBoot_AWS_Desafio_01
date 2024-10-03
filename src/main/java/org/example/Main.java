package org.example;

import org.example.entidades.Membro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;


public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafioB");
    private static EntityManager em = emf.createEntityManager();
    public static void main(String[] args) {
        Membro membro = new Membro(null, "augusto", "666", "teste22@gmail.com", "lauro", new Date());


//        Long id = 3L;
//        Membro m = em.find(Membro.class, id);
//        System.out.println(m);

        em.getTransaction().begin();
        em.persist(membro);
        em.getTransaction().commit();
    }
}
