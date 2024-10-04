package org.example.dao;

import javax.persistence.EntityManager;
import java.util.List;

public class Repositorio<T> {

    private EntityManager entityManager;
    private Class<T> entityClass;

    public Repositorio(EntityManager entityManager, Class<T> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    public void cadastrar(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public T buscarPorId(Long id) {
        return entityManager.find(entityClass, id);
    }

    public List<T> listarTodos() {
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        return entityManager.createQuery(jpql, entityClass).getResultList();
    }

    public void atualizar(T entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void deletar(Long id) {
        T entity = entityManager.find(entityClass, id);
        if (entity != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public String toString() {
        return "Repositorio{" +
                "entityManager=" + entityManager +
                ", entityClass=" + entityClass +
                '}';
    }
}
