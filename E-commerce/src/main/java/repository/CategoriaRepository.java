package br.edu.iff.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.iff.Ecommerce.model.Categoria;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("SELECT c FROM Categoria c WHERE LOWER(c.descricao) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<Categoria> encontrarPorParteDescricao(String parteDescricao);

    @Query("SELECT c FROM Categoria c WHERE c.produtos IS NOT EMPTY")
    List<Categoria> encontrarCategoriasComProdutos();
}