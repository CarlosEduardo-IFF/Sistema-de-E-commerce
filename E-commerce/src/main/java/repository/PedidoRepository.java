package br.edu.iff.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.iff.Ecommerce.model.Pedido;
import br.edu.iff.Ecommerce.model.Status;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query("SELECT p FROM Pedido p WHERE p.status = ?1")
    List<Pedido> encontrarPorStatus(Status status);


}