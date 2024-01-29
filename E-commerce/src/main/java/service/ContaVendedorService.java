package br.edu.iff.Ecommerce.service;

import br.edu.iff.Ecommerce.model.ContaVendedor;
import br.edu.iff.Ecommerce.repository.ContaVendedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaVendedorService {

    private final ContaVendedorRepository contaVendedorRepository;

    @Autowired
    public ContaVendedorService(ContaVendedorRepository contaVendedorRepository) {
        this.contaVendedorRepository = contaVendedorRepository;
    }

    public ContaVendedor adicionarContaVendedor(ContaVendedor contaVendedor) {
        return contaVendedorRepository.save(contaVendedor);
    }

    public ContaVendedor getContaVendedorById(Long id) {
        Optional<ContaVendedor> optionalContaVendedor = contaVendedorRepository.findById(id);
        return optionalContaVendedor.orElse(null);
    }

    public ContaVendedor atualizarContaVendedor(Long id, ContaVendedor contaVendedor) {
        Optional<ContaVendedor> optionalContaVendedor = contaVendedorRepository.findById(id);
        if (optionalContaVendedor.isPresent()) {
            ContaVendedor contaVendedorExistente = optionalContaVendedor.get();
         
            contaVendedorExistente.setQuantVendas(contaVendedor.getQuantVendas());
            contaVendedorExistente.setPtsAvaliacao(contaVendedor.getPtsAvaliacao());
            contaVendedorExistente.setDescricao(contaVendedor.getDescricao());
           
            return contaVendedorRepository.save(contaVendedorExistente);
        }
        return null; 
    }

    public boolean apagarContaVendedor(Long id) {
        if (contaVendedorRepository.existsById(id)) {
            contaVendedorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ContaVendedor encontrarPorCnpj(String cnpj) {
        return contaVendedorRepository.encontrarPorCnpj(cnpj);
    }

    public List<ContaVendedor> encontrarPorQuantVendasMaiorQue(int quantidadeVendas) {
        return contaVendedorRepository.encontrarPorQuantVendasMaiorQue(quantidadeVendas);
    }

    public List<ContaVendedor> encontrarPorPtsAvaliacaoMaiorQue(int pontuacaoAvaliacao) {
        return contaVendedorRepository.encontrarPorPtsAvaliacaoMaiorQue(pontuacaoAvaliacao);
    }
}
