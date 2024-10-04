package org.example.entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Autor extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_autor;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(nullable = false)
    private String nacionalidade;

    @Column(nullable = false)
    private String biografia;

    public Autor() {
    }

    public Autor(String nome, String nome1, Date dataNascimento, String nacionalidade, String biografia) {
        super(nome);
        this.nome = nome1;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.biografia = biografia;
    }

    public int getIdAutor() {
        return id_autor;
    }

    public void setIdAutor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id_autor=" + id_autor +
                ", nome='" + getNome() + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", biografia='" + biografia + '\'' +
                '}';
    }
}
