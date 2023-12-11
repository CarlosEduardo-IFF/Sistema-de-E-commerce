package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.CarrinhoDeCompra;
import model.ContaCliente;

import java.util.List;

public interface CarrinhoDeCompraRepository extends JpaRepository<CarrinhoDeCompra, Long> {

    @Query("SELECT c FROM CarrinhoDeCompra c WHERE c.cliente = ?1")
    CarrinhoDeCompra encontrarPorCliente(ContaCliente cliente);

    @Query("SELECT c FROM CarrinhoDeCompra c WHERE c.quantProdutos > ?1")
    List<CarrinhoDeCompra> encontrarComQuantProdutosMaiorQue(int quantidadeProdutos);

}
