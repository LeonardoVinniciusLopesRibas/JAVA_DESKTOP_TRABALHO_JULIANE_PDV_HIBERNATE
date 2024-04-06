package trabalho.juliane.pdv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "codigoRapido", length = 30)
    private String codigoRapido;
    
    @Column(name = "descricao", length = 100)
    private String descricao;
    
    @Column(name = "valorVenda")
    private double valorVenda;
    
    @Column(name = "ativo")
    private boolean ativo;

    public Produto() {
    }

    public Produto(int id, String codigoRapido, String descricao, double valorVenda, boolean ativo) {
        this.id = id;
        this.codigoRapido = codigoRapido;
        this.descricao = descricao;
        this.valorVenda = valorVenda;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoRapido() {
        return codigoRapido;
    }

    public void setCodigoRapido(String codigoRapido) {
        this.codigoRapido = codigoRapido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    
    
    
}
