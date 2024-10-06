package org.example.relatorios;

import org.example.interfaces.Relatorio;
import org.example.entidades.Livro;
import org.example.servico.LivroService;
import org.example.util.JPAUtil;

import java.util.List;

public class RelatorioLivros implements Relatorio {

    private final LivroService livroService = JPAUtil.getLivroService();

    @Override
    public void gerarRelatorio() {
        List<Livro> livros = livroService.listarTodos();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("---- Relatório de Livros ----");
            livros.forEach(livro -> {
                System.out.println("ID: " + livro.getIdLivro());
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor().getNome() + " (ID: " + livro.getAutor().getIdAutor() + ")");
                System.out.println("Gênero: " + livro.getGenero());
                System.out.println("Quantidade disponível: " + livro.getQuantidade());
                System.out.println("-----------------------------");
            });
        }
    }
}

