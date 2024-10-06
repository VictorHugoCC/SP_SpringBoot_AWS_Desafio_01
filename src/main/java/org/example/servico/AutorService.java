package org.example.servico;
import org.example.entidades.Autor;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class AutorService extends GenericService<Autor> {
    private final EntityManager entityManager;

    public AutorService(EntityManager entityManager) {
        super(entityManager, Autor.class);
        this.entityManager = entityManager;
    }

    public Autor buscarAutor(String nome) {
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
