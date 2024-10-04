package org.example.UI;

import org.example.entidades.Autor;
import org.example.entidades.Livro;
import org.example.servico.AutorService;
import org.example.servico.LivroService;
import org.example.util.InputUtil;
import org.example.util.JPAUtil;

import java.util.Date;

public class LivroMenu {

    AutorService autorService = JPAUtil.getAutorService();
    LivroService livroService = JPAUtil.getLivroService();

    public void exibirMenuLivro() {
        System.out.println("---- Cadastro de Livros ----");

        String titulo = InputUtil.obterInputObrigatorio("Título do Livro: ");
        String genero = InputUtil.obterInputObrigatorio("Gênero: ");
        String isbn;

        do {
            isbn = InputUtil.obterInputNumericoValido("ISBN: ");
            if (livroService.buscarLivroPorISBN(isbn) != null) {
                System.out.println("ISBN já está cadastrado. Por favor, insira um ISBN diferente.");
            }
        } while (livroService.buscarLivroPorISBN(isbn) != null);

        int quantidade = Integer.parseInt(InputUtil.obterInputNumericoValido("Quantidade: "));

        String nomeAutor = InputUtil.obterInputObrigatorio("Nome do Autor: ");
        Autor autor = autorService.buscarAutorPorNome(nomeAutor);

        if (autor != null) {
            Livro novoLivro = new Livro(titulo, autor, new Date(), isbn, genero, quantidade);
            livroService.cadastrar(novoLivro);
            System.out.println("Livro cadastrado com sucesso!");
        } else {
            System.out.println("Autor não encontrado. Verifique o nome e tente novamente.");
        }
    }
}
