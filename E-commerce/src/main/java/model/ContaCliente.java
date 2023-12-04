package model;

public class ContaCliente extends Conta {
	
    private double creditosCliente;
    private int quantCompras;
    private String cpf;
    
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
