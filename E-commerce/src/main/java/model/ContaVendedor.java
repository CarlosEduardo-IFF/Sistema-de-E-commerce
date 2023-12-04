package model;

public class ContaVendedor extends Conta {
	
    private int quantVendas;
    private int ptsAvaliacao;
    private String descricao;
    private String cnpj;
    
	public int getQuantVendas() {
		return quantVendas;
	}
	public void setQuantVendas(int quantVendas) {
		this.quantVendas = quantVendas;
	}
	public int getPtsAvaliacao() {
		return ptsAvaliacao;
	}
	public void setPtsAvaliacao(int ptsAvaliacao) {
		this.ptsAvaliacao = ptsAvaliacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

    
    
}
