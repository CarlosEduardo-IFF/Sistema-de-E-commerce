package br.edu.iff.Ecommerce.service;

import br.edu.iff.Ecommerce.model.Endereco;
import br.edu.iff.Ecommerce.repository.ContaRepository;
import br.edu.iff.Ecommerce.repository.EnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco adicionarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco getEnderecoById(Long id) {
        Optional<Endereco> optionalEndereco = enderecoRepository.findById(id);
        return optionalEndereco.orElse(null);
    }

    public Endereco atualizarEndereco(Long id, Endereco endereco) {
        Optional<Endereco> optionalEndereco = enderecoRepository.findById(id);
        if (optionalEndereco.isPresent()) {
            Endereco enderecoExistente = optionalEndereco.get();
            
            enderecoExistente.setRua(endereco.getRua());
            enderecoExistente.setNumero(endereco.getNumero());
            enderecoExistente.setCep(endereco.getCep());
            enderecoExistente.setBairro(endereco.getBairro());
            enderecoExistente.setCidade(endereco.getCidade());
            enderecoExistente.setEstado(endereco.getEstado());
            
            return enderecoRepository.save(enderecoExistente);
        }
        return null; 
    }

    public boolean apagarEndereco(Long id) {
        if (enderecoRepository.existsById(id)) {
            enderecoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Endereco> encontrarPorCidade(String cidade) {
        return enderecoRepository.encontrarPorCidade(cidade);
    }

    public List<Endereco> encontrarPorEstado(String estado) {
        return enderecoRepository.encontrarPorEstado(estado);
    }
}
