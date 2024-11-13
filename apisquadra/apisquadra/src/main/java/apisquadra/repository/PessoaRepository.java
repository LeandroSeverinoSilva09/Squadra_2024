package apisquadra.repository;

import apisquadra.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    boolean existsByLogin(String login);
}
