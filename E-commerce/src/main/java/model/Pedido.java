package model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private int idPedido;

    @Column(name = "valor_total", nullable = false)
    private double valorTotal;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "quant_produtos", nullable = false)
    private int quantProdutos;
    
    @ManyToOne
    @JoinColumn(name = "fk_cliente", nullable = false)
    private ContaCliente cliente;
    
    @OneToOne
    @JoinColumn(name = "fk_carrinho")
    private CarrinhoDeCompra carrinhoDeCompra;

    @ManyToOne
    @JoinColumn(name = "fk_status", nullable = false)
    private Status status;

    public Pedido(double valorTotal, LocalDateTime dataHora, int quantProdutos, Status status) {
        this.valorTotal = valorTotal;
        this.dataHora = dataHora;
        this.quantProdutos = quantProdutos;
        this.status = status;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getQuantProdutos() {
        return quantProdutos;
    }

    public void setQuantProdutos(int quantProdutos) {
        this.quantProdutos = quantProdutos;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
