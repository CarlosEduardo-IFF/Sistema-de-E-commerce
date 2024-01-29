package br.edu.iff.Ecommerce.service;

import br.edu.iff.Ecommerce.model.Pedido;
import br.edu.iff.Ecommerce.model.Status;
import br.edu.iff.Ecommerce.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido adicionarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido getPedidoById(Integer id) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
        return optionalPedido.orElse(null);
    }

    public Pedido atualizarPedido(Integer id, Pedido pedido) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
        if (optionalPedido.isPresent()) {
            Pedido pedidoExistente = optionalPedido.get();
           
            pedidoExistente.setValorTotal(pedido.getValorTotal());
            pedidoExistente.setDataHora(pedido.getDataHora());
            pedidoExistente.setQuantProdutos(pedido.getQuantProdutos());
            pedidoExistente.setStatus(pedido.getStatus());
           
            return pedidoRepository.save(pedidoExistente);
        }
        return null; 
    }

    public boolean apagarPedido(Integer id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Pedido> encontrarPorStatus(Status status) {
        return pedidoRepository.encontrarPorStatus(status);
    }
}

