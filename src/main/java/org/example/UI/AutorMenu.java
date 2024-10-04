package org.example.UI;

import org.example.entidades.Autor;
import org.example.servico.AutorService;
import org.example.util.InputUtil;
import org.example.util.JPAUtil;

import java.util.Date;

public class AutorMenu {

    AutorService autorService = JPAUtil.getAutorService();

    public void exibirMenuAutor() {
        System.out.println("---- Cadastro de Autores ----");

        String nome = InputUtil.obterInputObrigatorio("Nome do Autor: ");

        Autor autorExistente = autorService.buscarAutorPorNome(nome);
        if (autorExistente != null) {
            System.out.println("Erro: Já existe um autor registrado com esse nome.");
            return;
        }

        String nacionalidade = InputUtil.obterInputObrigatorio("Nacionalidade: ");
        String biografia = InputUtil.obterInputObrigatorio("Biografia: ");
        Date dataNascimento = new Date();

        Autor novoAutor = new Autor(null, nome, dataNascimento, nacionalidade, biografia);

        autorService.cadastrar(novoAutor);
        System.out.println("Autor cadastrado com sucesso!");
    }
}
