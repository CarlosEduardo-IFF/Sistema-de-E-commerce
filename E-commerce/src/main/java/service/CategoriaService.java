package br.edu.iff.Ecommerce.service;

import br.edu.iff.Ecommerce.model.Categoria;
import br.edu.iff.Ecommerce.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria adicionarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria getCategoriaById(Long id) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        return optionalCategoria.orElse(null);
    }

    public Categoria atualizarCategoria(Long id, Categoria categoria) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        if (optionalCategoria.isPresent()) {
            Categoria categoriaExistente = optionalCategoria.get();
          
            categoriaExistente.setDescricao(categoria.getDescricao());
       
            return categoriaRepository.save(categoriaExistente);
        }
        return null;
    }

    public boolean apagarCategoria(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Categoria> encontrarPorParteDescricao(String parteDescricao) {
        return categoriaRepository.encontrarPorParteDescricao(parteDescricao);
    }

    public List<Categoria> encontrarCategoriasComProdutos() {
        return categoriaRepository.encontrarCategoriasComProdutos();
    }
}
