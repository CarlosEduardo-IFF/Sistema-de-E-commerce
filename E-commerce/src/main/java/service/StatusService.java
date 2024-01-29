package br.edu.iff.Ecommerce.service;

import br.edu.iff.Ecommerce.model.Status;
import br.edu.iff.Ecommerce.repository.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Status adicionarStatus(Status status) {
        return statusRepository.save(status);
    }

    public Status getStatusById(Long id) {
        Optional<Status> optionalStatus = statusRepository.findById(id);
        return optionalStatus.orElse(null);
    }

    public Status atualizarStatus(Long id, Status status) {
        Optional<Status> optionalStatus = statusRepository.findById(id);
        if (optionalStatus.isPresent()) {
            Status statusExistente = optionalStatus.get();
           
            statusExistente.setDescricao(status.getDescricao());
            
            return statusRepository.save(statusExistente);
        }
        return null; 
    }

    public boolean apagarStatus(Long id) {
        if (statusRepository.existsById(id)) {
            statusRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Status> encontrarPorDescricao(String descricao) {
        return statusRepository.encontrarPorDescricao(descricao);
    }

    public List<Status> encontrarTodosOrdenadosPorDescricao() {
        return statusRepository.encontrarTodosOrdenadosPorDescricao();
    }
}
