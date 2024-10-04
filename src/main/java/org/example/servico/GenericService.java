package org.example.servico;

import org.example.dao.Repositorio;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class GenericService<T> {

    private Repositorio<T> repositorio;

    public GenericService(EntityManager entityManager, Class<T> entityClass) {
        this.repositorio = new Repositorio<>(entityManager, entityClass);
    }

    public void cadastrar(T entity) {
        try {
            repositorio.cadastrar(entity);
            System.out.println(entity.getClass().getSimpleName() + " cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar " + entity.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }

    public Optional<T> buscarPorId(Long id) {
        try {
            return Optional.ofNullable(repositorio.buscarPorId(id));
        } catch (Exception e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            return Optional.empty();
        }
    }

    public List<T> listarTodos() {
        try {
            return repositorio.listarTodos();
        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
            return List.of();
        }
    }

    public void atualizar(T entity) {
        try {
            repositorio.atualizar(entity);
            System.out.println(entity.getClass().getSimpleName() + " atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar " + entity.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }

    public void deletar(Long id) {
        try {
            Optional<T> entity = buscarPorId(id);
            entity.ifPresentOrElse(e -> {
                repositorio.deletar(id);
                System.out.println(e.getClass().getSimpleName() + " deletado com sucesso!");
            }, () -> System.out.println("Entidade com ID " + id + " não encontrada."));
        } catch (Exception e) {
            System.out.println("Erro ao deletar entidade: " + e.getMessage());
        }
    }
}
