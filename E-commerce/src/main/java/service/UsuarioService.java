package br.edu.iff.Ecommerce.service;

import br.edu.iff.Ecommerce.model.Usuario;
import br.edu.iff.Ecommerce.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario adicionarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuarioById(Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.orElse(null);
    }

    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuarioExistente = optionalUsuario.get();
          
            usuarioExistente.setNome(usuario.getNome());
           
            return usuarioRepository.save(usuarioExistente);
        }
		return usuario;
    }

    public boolean apagarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Usuario encontrarPorNome(String nome) {
        return usuarioRepository.encontrarPorNome(nome);
    }

    public List<Usuario> encontrarTodosOrdenadosPorNome() {
        return usuarioRepository.encontrarTodosOrdenadosPorNome();
    }

    public Usuario encontrarComEnderecosPorId(Long id) {
        return usuarioRepository.encontrarComEnderecosPorId(id);
    }
}
