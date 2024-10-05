package org.example.entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Membro extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_membro;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String endereco;

    @Column(name = "data_associacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAssociacao;

    @OneToMany(mappedBy = "membro")
    private List<Emprestimo> emprestimos;


    public Membro() {
    }
    public Membro(String nome, String telefone, String email, String endereco, Date dataAssociacao) {
        super(nome);
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.dataAssociacao = dataAssociacao;
    }

    public int getId_membro() {
        return id_membro;
    }

    public void setId_membro(int id_membro) {
        this.id_membro = id_membro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataAssociacao() {
        return dataAssociacao;
    }

    public void setDataAssociacao(Date dataAssociacao) {
        this.dataAssociacao = dataAssociacao;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    @Override
    public String toString() {
        return "Membro{" +
                "id_membro=" + id_membro +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataAssociacao=" + dataAssociacao +
                ", emprestimos=" + emprestimos +
                '}';
    }
}




