package org.example;

import org.example.entidades.Autor;
import org.example.entidades.Livro;
import org.example.entidades.Membro;
import org.example.util.JPAUtil;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // Criar um novo autor
        Autor novoAutor = new Autor("Gustavo", null, "J.K. Rowlinggg2122232", new Date(), "Reino Unido", "Famosa autora de fantasia");
        JPAUtil.getAutorService().cadastrar(novoAutor);

        // Criar um novo membro
//        Membro novoMembro = new Membro("Victor", null, "71991842010", "victor@gmail.com", "Patamares", new Date());
//        JPAUtil.getMembroService().cadastrar(novoMembro);

        // Criar um novo livro
        Livro novoLivro = new Livro(null, "Harry Potter e a Pedra Filosofal", novoAutor, new Date(), "1234567890123", "Ficção", 5);
        JPAUtil.getLivroService().cadastrar(novoLivro);

        // Exibir todos os livros cadastrados
        JPAUtil.getLivroService().listarTodos().forEach(System.out::println);

//        JPAUtil.getAutorService().listarTodos().forEach(System.out::println);
        // Fechar o EntityManager
        JPAUtil.fecharEntityManager();
    }
}
