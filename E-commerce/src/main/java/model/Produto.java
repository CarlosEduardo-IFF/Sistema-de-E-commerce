package model;

public class Produto {
	
    private int idProduto;
    private String nome;
    private String descricao;
    private double preco;
    private int quantDisponivel;
    private int avaliacao;
    private Categoria categoria;
    
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantDisponivel() {
		return quantDisponivel;
	}
	public void setQuantDisponivel(int quantDisponivel) {
		this.quantDisponivel = quantDisponivel;
	}
	public int getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
   
    
}