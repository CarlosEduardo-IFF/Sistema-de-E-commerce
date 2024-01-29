package br.edu.iff.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.iff.Ecommerce.model.Usuario;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE LOWER(u.nome) = LOWER(?1)")
    Usuario encontrarPorNome(String nome);

    @Query("SELECT u FROM Usuario u ORDER BY u.nome")
    List<Usuario> encontrarTodosOrdenadosPorNome();

    @Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.enderecos WHERE u.id = ?1")
    Usuario encontrarComEnderecosPorId(Long id);
}