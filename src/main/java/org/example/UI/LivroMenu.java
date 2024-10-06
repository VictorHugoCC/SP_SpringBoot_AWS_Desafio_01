package org.example.UI;

import org.example.entidades.Autor;
import org.example.entidades.Livro;
import org.example.servico.AutorService;
import org.example.servico.LivroService;
import org.example.util.InputUtil;
import org.example.util.JPAUtil;
import java.util.*;

public class LivroMenu {

    AutorService autorService = JPAUtil.getAutorService();
    LivroService livroService = JPAUtil.getLivroService();

    private Map<Autor, List<Livro>> livrosPorAutor = new HashMap<>();

    public void exibirMenuLivro() {
        try {
            System.out.println("---- Cadastro de Livros ----");
            String titulo = InputUtil.obterInputObrigatorio("Título do Livro: ");
            String genero = InputUtil.obterInputObrigatorio("Gênero: ");
            String isbn;

            do {
                isbn = InputUtil.obterInputNumericoValido("ISBN (apenas números): ");
                if (livroService.buscarLivro(isbn) != null) {
                    System.out.println("ISBN já está cadastrado. Por favor, insira um ISBN diferente.");
                }
            } while (livroService.buscarLivro(isbn) != null);

            int quantidade = Integer.parseInt(InputUtil.obterInputNumericoValido("Quantidade (apenas números): "));
            String nomeAutor = InputUtil.obterInputObrigatorio("Nome do Autor: ");
            Autor autor = autorService.buscarAutor(nomeAutor);

            if (autor != null) {
                Livro novoLivro = new Livro(titulo, autor, new Date(), isbn, genero, quantidade);
                livroService.cadastrar(novoLivro);
                livrosPorAutor.computeIfAbsent(autor, k -> new ArrayList<>()).add(novoLivro);
                System.out.println("Livro cadastrado e associado ao autor com sucesso!");
            } else {
                System.out.println("Autor não encontrado. Verifique o nome e tente novamente.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Erro de formato numérico: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar livro: " + e.getMessage());
        }
    }
}
