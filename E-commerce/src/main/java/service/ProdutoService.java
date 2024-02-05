package br.edu.iff.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.iff.ecommerce.model.Categoria;
import br.edu.iff.ecommerce.model.Produto;
import br.edu.iff.ecommerce.repository.CategoriaRepository;
import br.edu.iff.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Long id, Produto produto) {
        produto.setIdProduto(id);
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto adicionarCategoriaAoProduto(Long produtoId, Long categoriaId) {
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

        produto.getCategorias().add(categoria);
        return produtoRepository.save(produto);
    }

    public Produto removerCategoriaDoProduto(Long produtoId, Long categoriaId) {
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

        produto.getCategorias().remove(categoria);
        return produtoRepository.save(produto);
    }
    
    public List<Produto> buscarProdutosPorNome(String nome) {
        return produtoRepository.buscarPorNomeContendo(nome.toLowerCase());
    }

    public List<Produto> buscarProdutosPorPrecoMenorQue(double preco) {
        return produtoRepository.buscarPorPrecoMenorQue(preco);
    }
}
