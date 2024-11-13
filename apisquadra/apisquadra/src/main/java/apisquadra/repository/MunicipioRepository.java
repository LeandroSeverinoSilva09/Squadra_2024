package apisquadra.repository;

import apisquadra.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long> {

    boolean existsByCodigoUF(long codigoUF);
    boolean existsByNome(String nome);
}
