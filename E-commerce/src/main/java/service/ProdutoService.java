package br.edu.iff.Ecommerce.service;

import br.edu.iff.Ecommerce.model.Produto;
import br.edu.iff.Ecommerce.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto adicionarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto getProdutoById(Long id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        return optionalProduto.orElse(null);
    }

    public Produto atualizarProduto(Long id, Produto produto) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto produtoExistente = optionalProduto.get();
            
            produtoExistente.setNome(produto.getNome());
            produtoExistente.setDescricao(produto.getDescricao());
            produtoExistente.setPreco(produto.getPreco());
            produtoExistente.setQuantDisponivel(produto.getQuantDisponivel());
            produtoExistente.setAvaliacao(produto.getAvaliacao());
            produtoExistente.setCategorias(produto.getCategorias());
           
            return produtoRepository.save(produtoExistente);
        }
        return null; 
    }

    public boolean apagarProduto(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Produto> encontrarPorNome(String nome) {
        return produtoRepository.encontrarPorNome(nome);
    }

    public List<Produto> encontrarPorAvaliacaoMaiorQue(int avaliacao) {
        return produtoRepository.encontrarPorAvaliacaoMaiorQue(avaliacao);
    }

    public List<Produto> encontrarPorContaVendedor(Long idContaVendedor) {
        return produtoRepository.encontrarPorContaVendedor(idContaVendedor);
    }

    public List<Produto> encontrarPorCategoria(Long idCategoria) {
        return produtoRepository.encontrarPorCategoria(idCategoria);
    }

    public List<Produto> encontrarDisponiveis() {
        return produtoRepository.encontrarDisponiveis();
    }
}
