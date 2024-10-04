package org.example.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory desafioB = Persistence.createEntityManagerFactory("desafioB");

    public static EntityManager getEntityManager() {
        return desafioB.createEntityManager();

    }

}
