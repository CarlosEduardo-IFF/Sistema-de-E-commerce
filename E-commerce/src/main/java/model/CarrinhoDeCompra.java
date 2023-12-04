package model;

import java.util.List;

public class CarrinhoDeCompra {
	
    private int quantProdutos;
    private List<Produto> listaDeProdutos;
    
	public int getQuantProdutos() {
		return quantProdutos;
	}
	public void setQuantProdutos(int quantProdutos) {
		this.quantProdutos = quantProdutos;
	}
	public List<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}
	public void setListaDeProdutos(List<Produto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}
    
    
}
