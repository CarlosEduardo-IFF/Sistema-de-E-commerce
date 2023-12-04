package model;

import java.time.LocalDateTime;

public class Pedido {
	
    private int idPedido;
    private double valorTotal;
    private LocalDateTime dataHora;
    private int quantProdutos;
    private Status status;
    
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
