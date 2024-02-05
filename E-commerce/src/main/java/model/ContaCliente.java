package br.edu.iff.ecommerce.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contaCliente")
public class ContaCliente extends Conta {

	@Column(name = "col_creditos_cliente", nullable = false)
    private double creditosCliente;

    @Column(name = "col_quant_compras", nullable = false)
    private int quantCompras;

    @Column(name = "col_cpf", nullable = false, length = 14)
    private String cpf;
    
    @OneToOne
    @JoinColumn(name = "Col_fk_carrinho", nullable = false)
    private CarrinhoDeCompra carrinho;

    @ElementCollection
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Pedido> pedidos = new ArrayList<>();
    
    @ElementCollection
    @OneToMany(mappedBy = "contaCliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Endereco> enderecos;

	public ContaCliente() {
	}

	public ContaCliente(String email, String senha, String nomeUsuario, String cpf, CarrinhoDeCompra carrinho) {
		super(email, senha, nomeUsuario);
		this.quantCompras = 0;
		this.cpf = cpf;
		this.carrinho = carrinho;
		this.pedidos = new ArrayList<>();
	}

	public Collection<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Collection<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public double getCreditosCliente() {
        return creditosCliente;
    }

    public void setCreditosCliente(double creditosCliente) {
        this.creditosCliente = creditosCliente;
    }

     public int getQuantCompras() {
        return quantCompras;
    }

    public void setQuantCompras(int quantCompras) {
        this.quantCompras = quantCompras;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

	public CarrinhoDeCompra getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(CarrinhoDeCompra carrinho) {
		this.carrinho = carrinho;
	}

}
