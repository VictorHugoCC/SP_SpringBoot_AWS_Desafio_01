package org.example.entidades;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Emprestimo {


    public enum EstadoEmprestimo {
        ATIVO,
        CONCLUIDO,
        ATRASADO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_emprestimo;

    @ManyToOne
    @JoinColumn(name = "membro", nullable = false)
    private Membro membro;

    @ManyToMany
    @JoinTable(
            name = "emprestimo_livro",
            joinColumns = @JoinColumn(name = "emprestimo_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_id")
    )
    private List<Livro> livros;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_emprestimo", nullable = false)
    private Date dataEmprestimo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_devolucao")
    private Date dataDevolucao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoEmprestimo estado;

    @Column
    private BigDecimal multa;

    public Emprestimo() {
    }

    public int getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(int id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public EstadoEmprestimo getEstado() {
        return estado;
    }

    public void setEstado(EstadoEmprestimo estado) {
        this.estado = estado;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id_emprestimo=" + id_emprestimo +
                ", membro=" + membro +
                ", livros=" + livros +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                ", estado=" + estado +
                ", multa=" + multa +
                '}';
    }
}
