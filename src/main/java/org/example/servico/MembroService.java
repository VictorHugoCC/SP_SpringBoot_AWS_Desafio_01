package org.example.servico;

import org.example.dao.Repositorio;
import org.example.entidades.Membro;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MembroService {

    private Repositorio<Membro> membroRepositorio;

    public MembroService(EntityManager entityManager) {
        this.membroRepositorio = new Repositorio<>(entityManager, Membro.class);
    }

    public void cadastrarMembro(Membro membro) {
        try {
            membroRepositorio.cadastrar(membro);
            System.out.println("Membro cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar o membro: " + e.getMessage());
        }
    }

    public Optional<Membro> buscarMembro(Long id) {
        try {
            return Optional.ofNullable(membroRepositorio.buscarPorId(id));
        } catch (NoResultException e) {
            System.out.println("Erro: Membro com ID " + id + " não encontrado.");
            return Optional.empty();
        } catch (Exception e) {
            System.out.println("Erro inesperado ao buscar o membro: " + e.getMessage());
            return Optional.empty();
        }
    }

    public List<Membro> listarMembros() {
        try {
            return membroRepositorio.listarTodos();
        } catch (Exception e) {
            System.out.println("Erro ao listar membros: " + e.getMessage());
            return List.of(); // Retorna lista vazia em caso de erro
        }
    }

    public void exibirMembros() {
        try {
            List<Membro> membros = listarMembros();
            String resultado = membros.stream()
                    .map(membro -> "ID: " + membro.getIdMembro() +
                            ", Nome: " + membro.getNome() +
                            ", Email: " + membro.getEmail() +
                            ", Telefone: " + membro.getTelefone() +
                            ", Endereço: " + membro.getEndereco() +
                            ", Data de Associação: " + membro.getDataAssociacao())
                    .collect(Collectors.joining("\n"));

            // Exibe diretamente o resultado ou uma mensagem se a lista estiver vazia
            System.out.println(resultado.isEmpty() ? "Nenhum membro encontrado." : resultado);
        } catch (Exception e) {
            System.out.println("Erro ao exibir membros: " + e.getMessage());
        }
    }

    public void atualizarMembro(Membro membro) {
        try {
            membroRepositorio.atualizar(membro);
            System.out.println("Membro atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o membro: " + e.getMessage());
        }
    }

    public void deletarMembro(Long id) {
        try {
            Optional<Membro> membro = buscarMembro(id);
            membro.ifPresentOrElse(m -> {
                membroRepositorio.deletar(id);
                System.out.println("Membro deletado com sucesso!");
            }, () -> System.out.println("Membro com ID " + id + " não encontrado."));
        } catch (Exception e) {
            System.out.println("Erro ao deletar o membro: " + e.getMessage());
        }
    }
}
