package br.edu.iff.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_endereco")
public class Endereco{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "col_id_endereco")
    private Long id;

    @Column(name = "col_rua", length = 255) 
    private String rua;

    @Column(name = "col_numero", length = 10)
    private String numero;

    @Column(name = "col_cep", length = 8)
    private String cep;

    @Column(name = "col_bairro", length = 255)
    private String bairro;

    @Column(name = "col_cidade", length = 255)
    private String cidade;

    @Column(name = "col_estado", length = 255)
    private String estado;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "col_id_conta_cliente")
    private ContaCliente contaCliente;
    
    public Endereco(String rua, String numero, String cep, String bairro, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero == null || numero.isEmpty()) {
            throw new IllegalArgumentException("Número não pode ser nulo ou vazio");
        }

        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (cep == null || cep.isEmpty()) {
            throw new IllegalArgumentException("CEP não pode ser nulo ou vazio");
        }

        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
