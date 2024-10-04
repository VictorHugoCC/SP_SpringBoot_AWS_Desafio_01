package org.example.servico;

import org.example.dao.Repositorio;
import org.example.entidades.Autor;

import javax.persistence.EntityManager;
import java.util.List;

public class AutorService {

    private Repositorio<Autor> autorRepositorio;

    public AutorService(EntityManager entityManager) {
        this.autorRepositorio = new Repositorio<>(entityManager, Autor.class);
    }

    public void cadastrarAutor(Autor autor) {
        autorRepositorio.cadastrar(autor);
    }

    public Autor buscarAutor(Long id) {
        return autorRepositorio.buscarPorId(id);
    }

    public List<Autor> listarAutores() {
        return autorRepositorio.listarTodos();
    }

    public void atualizarAutor(Autor autor) {
        autorRepositorio.atualizar(autor);
    }

    public void deletarAutor(Long id) {
        autorRepositorio.deletar(id);
    }
}
