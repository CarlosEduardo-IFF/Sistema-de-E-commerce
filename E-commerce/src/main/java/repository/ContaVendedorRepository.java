package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.ContaVendedor;

import java.util.List;

public interface ContaVendedorRepository extends JpaRepository<ContaVendedor, Long> {

    @Query("SELECT cv FROM ContaVendedor cv WHERE cv.cnpj = ?1")
    ContaVendedor encontrarPorCnpj(String cnpj);

    @Query("SELECT cv FROM ContaVendedor cv WHERE cv.quantVendas > ?1")
    List<ContaVendedor> encontrarPorQuantVendasMaiorQue(int quantidadeVendas);

    @Query("SELECT cv FROM ContaVendedor cv WHERE cv.ptsAvaliacao > ?1")
    List<ContaVendedor> encontrarPorPtsAvaliacaoMaiorQue(int pontuacaoAvaliacao);
}