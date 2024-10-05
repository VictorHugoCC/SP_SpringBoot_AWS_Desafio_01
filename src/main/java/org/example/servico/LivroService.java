package org.example.servico;

import org.example.entidades.Livro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class LivroService extends GenericService<Livro> {
    private static final EntityManagerFactory desafioB = Persistence.createEntityManagerFactory("desafioB");
    private static final EntityManager entityManager = desafioB.createEntityManager();

    public LivroService(EntityManager entityManager) {
        super(entityManager, Livro.class);
    }

    public Livro buscarLivro(String isbn) {
        try {
            String jpql = "SELECT l FROM Livro l WHERE l.isbn = :isbn";
            return entityManager.createQuery(jpql, Livro.class)
                    .setParameter("isbn", isbn)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
            return null;
        }
    }


}
