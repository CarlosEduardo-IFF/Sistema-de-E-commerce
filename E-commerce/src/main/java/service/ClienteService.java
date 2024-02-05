package br.edu.iff.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ecommerce.model.CarrinhoDeCompra;
import br.edu.iff.ecommerce.model.ContaCliente;
import br.edu.iff.ecommerce.repository.CarrinhoDeCompraRepository;
import br.edu.iff.ecommerce.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository contaClienteRepository;

    @Autowired
    private CarrinhoDeCompraRepository carrinhoDeCompraRepository;

    public ContaCliente criarContaCliente(String email, String senha, String nomeUsuario, String cpf) {
        if (contaClienteRepository.buscarPorEmail(email) != null) {
            throw new RuntimeException("E-mail já cadastrado.");
        }
        
        if (contaClienteRepository.buscarPorCpf(cpf) != null) {
            throw new RuntimeException("CPF já cadastrado.");
        }
        
        CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
        carrinhoDeCompraRepository.save(carrinho);

        ContaCliente novaContaCliente = new ContaCliente(email, senha, nomeUsuario, cpf, carrinho);
        return contaClienteRepository.save(novaContaCliente);
    }

    public void removerCliente(Long id) {
        contaClienteRepository.removerPorId(id);
    }

    public void alterarCredito(Long id, double novoCredito) {
        contaClienteRepository.alterarCredito(id, novoCredito);
    }

    public void alterarNome(Long id, String novoNome) {
        contaClienteRepository.alterarNome(id, novoNome);
    }

    public Optional<ContaCliente> buscarPorId(Long id) {
        return contaClienteRepository.findById(id);
    }

    public ContaCliente buscarPorEmail(String email) {
        return contaClienteRepository.buscarPorEmail(email);
    }

    public ContaCliente buscarPorCpf(String cpf) {
        return contaClienteRepository.buscarPorCpf(cpf);
    }

}