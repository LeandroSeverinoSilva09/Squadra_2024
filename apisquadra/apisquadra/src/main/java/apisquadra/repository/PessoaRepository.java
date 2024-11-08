package apisquadra.repository;

import apisquadra.DTO.Municipio;
import apisquadra.DTO.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
