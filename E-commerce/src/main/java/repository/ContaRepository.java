package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    @Query("SELECT c FROM Conta c WHERE c.email = ?1")
    Conta encontrarPorEmail(String email);

    @Query("SELECT COUNT(c) > 0 FROM Conta c WHERE c.email = ?1")
    boolean existePorEmail(String email);

}
