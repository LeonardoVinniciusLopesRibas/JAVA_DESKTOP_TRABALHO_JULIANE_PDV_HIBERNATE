package trabalho.juliane.pdv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nome", length = 100)
    private String nome;
    
    @Column(name = "cpfcnpj", length = 14)
    private String cpfcnpj;
    
    @Column(name = "ativo")
    private boolean ativo;

    public Cliente() {
    }

    public Cliente(int id, String nome, String cpfcnpj, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.cpfcnpj = cpfcnpj;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
    
    
}
