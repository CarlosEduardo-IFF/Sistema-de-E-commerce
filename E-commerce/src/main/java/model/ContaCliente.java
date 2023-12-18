package br.edu.iff.Ecommerce.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

@Entity
public class ContaCliente extends Conta {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "col_creditos_cliente", nullable = false)
    private double creditosCliente;

    @Column(name = "col_quant_compras", nullable = false)
    private int quantCompras;

    @Column(name = "col_cpf", nullable = false, length = 14)
    private String cpf;

    @ElementCollection
    private Collection<Pedido> pedidos;
    



	public ContaCliente(String email, String senha, Usuario usuario, double creditosCliente, int quantCompras,
			String cpf, Collection<Pedido> pedidos) {
		super(email, senha, usuario);
		this.creditosCliente = creditosCliente;
		this.quantCompras = quantCompras;
		this.cpf = cpf;
		this.pedidos = pedidos;
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
}
