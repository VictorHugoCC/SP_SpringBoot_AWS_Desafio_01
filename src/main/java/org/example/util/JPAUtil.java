package org.example.util;

import org.example.entidades.Emprestimo;
import org.example.servico.AutorService;
import org.example.servico.EmprestimoService;
import org.example.servico.LivroService;
import org.example.servico.MembroService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory desafioB = Persistence.createEntityManagerFactory("desafioB");
    private static EntityManager em = desafioB.createEntityManager();

    // Retorna o EntityManager
    public static EntityManager getEntityManager() {
        return em;
    }

    // Retorna o MembroService
    public static MembroService getMembroService() {
        return new MembroService(em);
    }

    // Retorna o AutorService
    public static AutorService getAutorService() {
        return new AutorService(em);
    }
    // Retorna o LivroService
    public static LivroService getLivroService() {
        return new LivroService(em);
    }

    public static EmprestimoService getEmprestimoService() {
        return new EmprestimoService(em);
    }

}
