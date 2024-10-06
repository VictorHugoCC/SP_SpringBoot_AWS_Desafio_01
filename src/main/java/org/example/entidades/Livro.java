package org.example.entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_livro;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor", nullable = false)
    private Autor autor;

    @Column(name = "data_publicacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataPublicacao;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private int quantidade;

    public Livro() {
    }

    public Livro(String titulo, Autor autor, Date dataPublicacao, String isbn, String genero, int quantidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.isbn = isbn;
        this.genero = genero;
        this.quantidade = quantidade;
    }

    public int getIdLivro() {
        return id_livro;
    }

    public void setIdLivro(int id_livro) {
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
                ", isbn='" + isbn + '\'' +
                ", genero='" + genero + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
