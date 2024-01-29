package br.edu.iff.Ecommerce.service;

import br.edu.iff.Ecommerce.model.CarrinhoDeCompra;
import br.edu.iff.Ecommerce.model.ContaCliente;
import br.edu.iff.Ecommerce.repository.CarrinhoDeCompraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoDeCompraService {

    private final CarrinhoDeCompraRepository carrinhoDeCompraRepository;

    @Autowired
    public CarrinhoDeCompraService(CarrinhoDeCompraRepository carrinhoDeCompraRepository) {
        this.carrinhoDeCompraRepository = carrinhoDeCompraRepository;
    }

    public CarrinhoDeCompra adicionarCarrinho(CarrinhoDeCompra carrinhoDeCompra) {
        return carrinhoDeCompraRepository.save(carrinhoDeCompra);
    }

    public CarrinhoDeCompra getCarrinhoById(Long id) {
        Optional<CarrinhoDeCompra> optionalCarrinho = carrinhoDeCompraRepository.findById(id);
        return optionalCarrinho.orElse(null);
    }

    public CarrinhoDeCompra atualizarCarrinho(Long id, CarrinhoDeCompra carrinhoDeCompra) {
        Optional<CarrinhoDeCompra> optionalCarrinho = carrinhoDeCompraRepository.findById(id);
        if (optionalCarrinho.isPresent()) {
            CarrinhoDeCompra carrinhoExistente = optionalCarrinho.get();

            carrinhoExistente.setQuantProdutos(carrinhoDeCompra.getQuantProdutos());
            carrinhoExistente.setListaDeProdutos(carrinhoDeCompra.getListaDeProdutos());

            return carrinhoDeCompraRepository.save(carrinhoExistente);
        }
        return null; 
    }

    public boolean apagarCarrinho(Long id) {
        if (carrinhoDeCompraRepository.existsById(id)) {
            carrinhoDeCompraRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<CarrinhoDeCompra> encontrarComQuantProdutosMaiorQue(int quantidadeProdutos) {
        return carrinhoDeCompraRepository.encontrarComQuantProdutosMaiorQue(quantidadeProdutos);
    }

    public CarrinhoDeCompra encontrarPorCliente(ContaCliente cliente) {
        return carrinhoDeCompraRepository.encontrarPorCliente(cliente);
    }
}
