package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Pedido;
import model.Status;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query("SELECT p FROM Pedido p WHERE p.status = ?1")
    List<Pedido> encontrarPorStatus(Status status);

    @Query("SELECT p FROM Pedido p WHERE p.cliente.idContaCliente = ?1")
    List<Pedido> encontrarPorCliente(Long idCliente);
}