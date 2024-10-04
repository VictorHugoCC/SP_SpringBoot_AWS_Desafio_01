package org.example.servico;
import org.example.entidades.Livro;
import javax.persistence.EntityManager;
import java.util.List;

public class LivroService extends GenericService<Livro> {

    public LivroService(EntityManager entityManager) {
        super(entityManager, Livro.class);
    }

}

