package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.ContaCliente;

import java.util.List;

public interface ContaClienteRepository extends JpaRepository<ContaCliente, Long> {

    @Query("SELECT cc FROM ContaCliente cc WHERE cc.cpf = ?1")
    ContaCliente encontrarPorCpf(String cpf);

    @Query("SELECT cc FROM ContaCliente cc WHERE cc.quantCompras > ?1")
    List<ContaCliente> encontrarPorQuantComprasMaiorQue(int quantidadeCompras);

    @Query("SELECT cc FROM ContaCliente cc WHERE cc.creditosCliente > ?1")
    List<ContaCliente> encontrarPorCreditosMaiorQue(double creditos);
}