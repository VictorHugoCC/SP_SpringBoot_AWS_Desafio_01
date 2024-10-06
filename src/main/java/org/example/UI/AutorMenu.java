package org.example.UI;

import org.example.entidades.Autor;
import org.example.servico.AutorService;
import org.example.util.InputUtil;
import org.example.util.JPAUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AutorMenu {

    AutorService autorService = JPAUtil.getAutorService();

    public void exibirMenuAutor() {
        System.out.println("---- Cadastro de Autores ----");

        try {
            String nome = InputUtil.obterInputObrigatorio("Nome do Autor: ");

            Autor autorExistente = autorService.buscarAutor(nome);
            if (autorExistente != null) {
                System.out.println("Erro: Já existe um autor registrado com esse nome.");
                return;
            }

            String nacionalidade = InputUtil.obterInputObrigatorio("Nacionalidade: ");
            String biografia = InputUtil.obterInputObrigatorio("Biografia: ");

            String dataNascimentoStr = InputUtil.obterInputObrigatorio("Data de Nascimento (formato yyyy-MM-dd): ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dataNascimento;

            try {
                dataNascimento = dateFormat.parse(dataNascimentoStr);
            } catch (ParseException e) {
                System.out.println("Formato de data inválido. Use o formato yyyy-MM-dd.");
                return;
            }

            Autor novoAutor = new Autor(null, nome, dataNascimento, nacionalidade, biografia);
            autorService.cadastrar(novoAutor);
            System.out.println("Autor cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar autor: " + e.getMessage());
        }
    }
}
