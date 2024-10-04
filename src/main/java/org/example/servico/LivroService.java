package org.example.servico;

import org.example.dao.Repositorio;
import org.example.entidades.Livro;

import javax.persistence.EntityManager;
import java.util.List;

public class LivroService {

    private Repositorio<Livro> livroRepositorio;

    public LivroService(EntityManager entityManager) {
        this.livroRepositorio = new Repositorio<>(entityManager, Livro.class);
    }

    public void cadastrarLivro(Livro livro) {
        livroRepositorio.cadastrar(livro);
    }

    public Livro buscarLivro(Long id) {
        return livroRepositorio.buscarPorId(id);
    }

    public List<Livro> listarLivros() {
        return livroRepositorio.listarTodos();
    }

    public void atualizarLivro(Livro livro) {
        livroRepositorio.atualizar(livro);
    }

    public void deletarLivro(Long id) {
        livroRepositorio.deletar(id);
    }
}
