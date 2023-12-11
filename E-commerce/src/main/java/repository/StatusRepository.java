package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Status;

import java.util.List;
import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Long> {

    @Query("SELECT s FROM Status s WHERE LOWER(s.descricao) = LOWER(?1)")
    Optional<Status> encontrarPorDescricao(String descricao);

    @Query("SELECT s FROM Status s ORDER BY s.descricao")
    List<Status> encontrarTodosOrdenadosPorDescricao();
}
