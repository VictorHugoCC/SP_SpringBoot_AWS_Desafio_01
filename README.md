# 📚 Sistema de Gerenciamento de Biblioteca

## 📝 Descrição

Este projeto é um Sistema de Gerenciamento de Biblioteca, desenvolvido em Java, que permite realizar operações como cadastro de livros, autores, membros, além de gerenciar empréstimos e devoluções. O sistema inclui funcionalidades de geração de relatórios, cálculo de multas por atraso e categorização dos estados dos empréstimos.

## 📑 Índice

- [Funcionalidades](#funcionalidades)
- [Pré-requisitos](#pré-requisitos)
- [Configuração do Banco de Dados](#configuração-do-banco-de-dados)
- [Como Executar o Projeto](#como-executar-o-projeto)
- [Demonstração](#demonstração)

## 🚀 Funcionalidades

- **Cadastro de Livros:** Permite adicionar livros ao sistema, incluindo informações como título, autor, gênero, quantidade, e ISBN único.
- **Cadastro de Autores:** Cadastrar autores e associá-los aos livros.
- **Cadastro de Membros:** Cadastrar membros com informações de contato e endereço.
- **Empréstimo e Devolução de Livros:** Controla a saída e retorno de livros, calcula multas por atraso e verifica a disponibilidade dos livros.
- **Relatórios:** Gera relatórios detalhados sobre livros, membros, empréstimos, autores e empréstimos atrasados.

## 🧰 Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

- [Java JDK 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [MySQL](https://dev.mysql.com/downloads/installer/): Um banco de dados MySQL configurado e em execução.
- [Maven](https://maven.apache.org/install.html): Para compilar e gerenciar as dependências do projeto.

## 🛠 Configuração do Banco de Dados

Antes de executar o projeto, é necessário configurar o banco de dados MySQL:

1. Crie um banco de dados chamado `Desafio_01` no MySQL.
2. No arquivo `persistence.xml`, configure as credenciais de acesso ao banco de dados.

## 🚀 Como Executar o Projeto

1. **Clone o repositório:**

    ```bash
    git clone https://github.com/VictorHugoCC/SP_SpringBoot_AWS_Desafio_01.git
    cd SP_SpringBoot_AWS_Desafio_01/Desafio-01/src/main/java/org.example/main
    ```
   E então execute o programa.


<h1>🎬 Demonstração</h1>

![Texto Alternativo](src/main/java/org/example/Media/GravaodeTela2024-10-06202144-ezgif.com-video-to-gif-converter.gif)

## 📂 Estrutura de Pastas

### dao
- **Repositorio:** Classe que implementa as operações básicas de persistência de dados. Tambem inicializa o CRUD.

### entidades
- **Autor:** Representa os autores dos livros.
- **Emprestimo:** Gerencia as informações de empréstimos, como datas, multas e estados.
- **Livro:** Representa os livros na biblioteca, com informações de autor, ISBN, e quantidade disponível.
- **Membro:** Contém as informações dos membros da biblioteca.
- **Pessoa:** Classe base para Membro e Autor.

### interfaces
- **Relatorio:** Interface que define o método `gerarRelatorio()` para a geração de relatórios personalizados.

### relatorios
- **RelatorioAutores:** Gera um relatório com informações dos autores cadastrados.
- **RelatorioEMAtrasados:** Lista empréstimos atrasados e detalha os dias de atraso.
- **RelatorioEmprestimos:** Apresenta um relatório geral de todos os empréstimos.
- **RelatorioLivros:** Relatório detalhado sobre todos os livros, incluindo autores e disponibilidade.
- **RelatorioMembros:** Gera um relatório com detalhes de todos os membros.

### servico
- **AutorService:** Contém operações específicas para gerenciamento de autores.
- **EmprestimoService:** Realiza operações de empréstimos e devoluções, incluindo o cálculo de multas.
- **GenericService:** Classe genérica que oferece métodos comuns de serviço.
- **LivroService:** Contém operações específicas para gerenciamento de livros.
- **MembroService:** Contém operações específicas para gerenciamento de membros.

### UI
- **AutorMenu:** Interface de usuário para cadastro e gerenciamento de autores.
- **EmprestimoMenu:** Interface de usuário para gerenciar empréstimos e devoluções de livros.
- **LivroMenu:** Interface de usuário para cadastro e gerenciamento de livros.
- **MembroMenu:** Interface de usuário para cadastro e gerenciamento de membros.
- **MenuPrincipal:** Interface principal que conecta todas as funcionalidades do sistema.
- **RelatoriosMenu:** Interface de usuário para geração de diferentes relatórios.

### util
- **InputUtil:** Métodos auxiliares para captura e validação de entrada do usuário.
- **JPAUtil:** Configuração do EntityManager para persistência de dados.