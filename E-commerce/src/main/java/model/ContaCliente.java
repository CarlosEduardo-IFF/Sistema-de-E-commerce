package model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;

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
    
    @JoinColumn(name="id_cliente")
    private List<Pedido> pedidos;

    public ContaCliente(String email, String senha, Usuario usuario, double creditosCliente, int quantCompras,
			String cpf) {
		super(email, senha, usuario);
		this.creditosCliente = creditosCliente;
		this.quantCompras = quantCompras;
		this.cpf = cpf;
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
