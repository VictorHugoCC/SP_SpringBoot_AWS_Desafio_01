package org.example.entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_livro;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @Column(name = "data_publicacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataPublicacao;

    @Column(nullable = false, unique = true)
    private String isb;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private int quantidade;

    public Livro() {
    }

    public Livro(Long id_livro, String titulo, Autor autor, Date dataPublicacao, String isb, String genero, int quantidade) {
        this.id_livro = id_livro;
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.isb = isb;
        this.genero = genero;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public Long getIdLivro() {
        return id_livro;
    }

    public void setIdLivro(Long id_livro) {
        this.id_livro = id_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getIsb() {
        return isb;
    }

    public void setIsb(String isb) {
        this.isb = isb;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id_livro=" + id_livro +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", dataPublicacao=" + dataPublicacao +
                ", isb='" + isb + '\'' +
                ", genero='" + genero + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
