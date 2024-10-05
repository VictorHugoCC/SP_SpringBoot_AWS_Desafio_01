package org.example.servico;
import org.example.entidades.Membro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class MembroService extends GenericService<Membro> {
    private static final EntityManagerFactory desafioB = Persistence.createEntityManagerFactory("desafioB");
    private static EntityManager entityManager = desafioB.createEntityManager();

    public MembroService(EntityManager entityManager) {
        super(entityManager, Membro.class);
    }

    public Membro buscarMembro(String email) {
        try {
            String jpql = "SELECT m FROM Membro m WHERE LOWER(m.email) = LOWER(:email)";
            return entityManager.createQuery(jpql, Membro.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
            return null;
        }
    }

}
