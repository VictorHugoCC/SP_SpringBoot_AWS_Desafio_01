package org.example.servico;
import org.example.entidades.Membro;
import javax.persistence.EntityManager;

public class MembroService extends GenericService<Membro> {

    public MembroService(EntityManager entityManager) {
        super(entityManager, Membro.class);
    }

}
