package org.example.relatorios;

import org.example.entidades.Autor;
import org.example.interfaces.Relatorio;
import org.example.servico.AutorService;
import org.example.util.JPAUtil;

import java.util.List;

public class RelatorioAutores implements Relatorio {

    private final AutorService autorService;

    public RelatorioAutores() {
        this.autorService = JPAUtil.getAutorService();
    }

    @Override
    public void gerarRelatorio() {
        List<Autor> autores = autorService.listarTodos();
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor cadastrado.");
        } else {
            System.out.println("---- Relatório de Autores ----");
            autores.forEach(autor -> {
                System.out.println("ID: " + autor.getIdAutor());
                System.out.println("Nome: " + autor.getNome());
                System.out.println("Nacionalidade: " + autor.getNacionalidade());
                System.out.println("Biografia: " + autor.getBiografia());
                System.out.println("-----------------------------");
            });
        }
    }
}
