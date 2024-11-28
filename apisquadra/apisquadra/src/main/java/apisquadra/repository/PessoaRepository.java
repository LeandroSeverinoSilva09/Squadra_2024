package apisquadra.repository;


import apisquadra.model.Pessoa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    boolean existsByLogin(String login);
    Pessoa findByCodigoPessoa (Long codigoPessoa);
    List<Pessoa> findByStatus(Integer status);
    List<Pessoa> findByLogin(String login);
}
