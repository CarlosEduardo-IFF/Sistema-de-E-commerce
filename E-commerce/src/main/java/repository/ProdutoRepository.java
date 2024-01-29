package br.edu.iff.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.iff.Ecommerce.model.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE LOWER(p.nome) = LOWER(?1)")
    List<Produto> encontrarPorNome(String nome);

    @Query("SELECT p FROM Produto p WHERE p.avaliacao > ?1")
    List<Produto> encontrarPorAvaliacaoMaiorQue(int avaliacao);

    @Query("SELECT p FROM Produto p WHERE p.contaVendedor.id = ?1")
    List<Produto> encontrarPorContaVendedor(Long idContaVendedor);

    @Query("SELECT p FROM Produto p JOIN p.categorias c WHERE c.id = ?1")
    List<Produto> encontrarPorCategoria(Long idCategoria);

    @Query("SELECT p FROM Produto p WHERE p.quantDisponivel > 0")
    List<Produto> encontrarDisponiveis();
}