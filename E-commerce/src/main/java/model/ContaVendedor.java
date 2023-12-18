package br.edu.iff.Ecommerce.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class ContaVendedor extends Conta {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "col_quant_vendas", nullable = false)
    private int quantVendas;

    @Column(name = "col_pts_avaliacao", nullable = false)
    private int ptsAvaliacao;

    @Column(name = "col_descricao", nullable = false, length = 255)
    private String descricao;

    @Column(name = "col_cnpj", nullable = false, length = 18)
    private String cnpj;
    
    @OneToMany(mappedBy = "contaVendedor")
    private List<Produto> produtos;

	public ContaVendedor(String email, String senha, Usuario usuario, int quantVendas, int ptsAvaliacao,
			String descricao, String cnpj, List<Produto> produtos) {
		super(email, senha, usuario);
		this.quantVendas = quantVendas;
		this.ptsAvaliacao = ptsAvaliacao;
		this.descricao = descricao;
		this.cnpj = cnpj;
		this.produtos = produtos;
	}

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