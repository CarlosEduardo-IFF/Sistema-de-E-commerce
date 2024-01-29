package br.edu.iff.Ecommerce.service;

import br.edu.iff.Ecommerce.model.ContaCliente;
import br.edu.iff.Ecommerce.repository.ContaClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ContaClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ContaClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ContaCliente adicionarCliente(ContaCliente cliente) {
        return clienteRepository.save(cliente);
    }

    public ContaCliente getClienteById(Long id) {
        Optional<ContaCliente> optionalCliente = clienteRepository.findById(id);
        return optionalCliente.orElse(null);
    }

    public ContaCliente atualizarCliente(Long id, ContaCliente cliente) {
        Optional<ContaCliente> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            ContaCliente clienteExistente = optionalCliente.get();
         
            clienteExistente.setCreditosCliente(cliente.getCreditosCliente());
            clienteExistente.setQuantCompras(cliente.getQuantCompras());
            clienteExistente.setCpf(cliente.getCpf());
            
            return clienteRepository.save(clienteExistente);
        }
        return null; 
    }

    public boolean apagarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ContaCliente encontrarPorCpf(String cpf) {
        return clienteRepository.encontrarPorCpf(cpf);
    }

    public List<ContaCliente> encontrarPorQuantComprasMaiorQue(int quantidadeCompras) {
        return clienteRepository.encontrarPorQuantComprasMaiorQue(quantidadeCompras);
    }

    public List<ContaCliente> encontrarPorCreditosMaiorQue(double creditos) {
        return clienteRepository.encontrarPorCreditosMaiorQue(creditos);
    }
}

