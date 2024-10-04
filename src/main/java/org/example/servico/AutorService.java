package org.example.servico;
import org.example.entidades.Autor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class AutorService extends GenericService<Autor> {
    private static final EntityManagerFactory desafioB = Persistence.createEntityManagerFactory("desafioB");
    private static EntityManager entityManager = desafioB.createEntityManager();

    public AutorService(EntityManager entityManager) {
        super(entityManager, Autor.class);
    }

    public Autor buscarAutorPorNome(String nome) {
        try {
            String jpql = "SELECT a FROM Autor a WHERE LOWER(a.nome) = LOWER(:nome)";
            return entityManager.createQuery(jpql, Autor.class)
                    .setParameter("nome", nome)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
            return null;
        }
    }



}
