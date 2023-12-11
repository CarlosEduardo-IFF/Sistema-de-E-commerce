package model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class CarrinhoDeCompra implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrinho")
    private Long idCarrinho;

    @Column(name = "quant_produtos", nullable = false)
    private int quantProdutos;
    
    @OneToOne
    @JoinColumn(name = "fk_cliente", nullable = false)
    private ContaCliente cliente;

    @ManyToMany
    @JoinTable(
            name = "carrinho_produto",
            joinColumns = @JoinColumn(name = "fk_carrinho"),
            inverseJoinColumns = @JoinColumn(name = "fk_produto")
    )
    private List<Produto> listaDeProdutos;

    public CarrinhoDeCompra() {
    }

    public CarrinhoDeCompra(int quantProdutos, List<Produto> listaDeProdutos) {
        this.quantProdutos = quantProdutos;
        this.listaDeProdutos = listaDeProdutos;
    }

    public Long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

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
