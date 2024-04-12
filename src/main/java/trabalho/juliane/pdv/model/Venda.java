package trabalho.juliane.pdv.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "valorTotal")
    private double valorTotal;

    @OneToOne
    private Cliente cliente;

    @Column(name = "valorTotalDesconto")
    private double valorTotalDesconto;

    @Column(name = "qtdItens")
    private int qtdItens;

    @Column(name = "ativo")
    private boolean ativo;

    @Transient
    private List<ItemVenda> itensVenda;

    public Venda() {
    }

    public Venda(int id, double valorTotal, Cliente cliente, double valorTotalDesconto, int qtdItens, boolean ativo) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.valorTotalDesconto = valorTotalDesconto;
        this.qtdItens = qtdItens;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorTotalDesconto() {
        return valorTotalDesconto;
    }

    public void setValorTotalDesconto(double valorTotalDesconto) {
        this.valorTotalDesconto = valorTotalDesconto;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(int qtdItens) {
        this.qtdItens = qtdItens;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
