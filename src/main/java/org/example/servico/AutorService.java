package org.example.servico;
import org.example.entidades.Autor;
import javax.persistence.EntityManager;

public class AutorService extends GenericService<Autor> {

    public AutorService(EntityManager entityManager) {
        super(entityManager, Autor.class);
    }
}
