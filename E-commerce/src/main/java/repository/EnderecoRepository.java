package br.edu.iff.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.iff.Ecommerce.model.Endereco;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("SELECT e FROM Endereco e WHERE LOWER(e.cidade) = LOWER(?1)")
    List<Endereco> encontrarPorCidade(String cidade);

    @Query("SELECT e FROM Endereco e WHERE LOWER(e.estado) = LOWER(?1)")
    List<Endereco> encontrarPorEstado(String estado);

}
