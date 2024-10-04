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
    @JoinColumn(name = "membro_id", nullable = false)
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
    @Column(name = "data_devolucao", nullable = true)
    private Date dataDevolucao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoEmprestimo estado;

    @Column(nullable = true)
    private BigDecimal multa;

    public Emprestimo() {}

    public Emprestimo(Membro membro, List<Livro> livros, Date dataEmprestimo, Date dataDevolucao, EstadoEmprestimo estado, BigDecimal multa) {
        this.membro = membro;
        this.livros = livros;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.estado = estado;
        this.multa = multa;
    }

    public int getIdEmprestimo() {
        return id_emprestimo;
    }

    public void setIdEmprestimo(int id_emprestimo) {
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
}
