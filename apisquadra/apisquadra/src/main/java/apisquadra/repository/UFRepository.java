package apisquadra.repository;

import apisquadra.model.UF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UFRepository extends JpaRepository<UF, Long> {

    List<UF> findByStatus(int status);
    UF findByNome(String nome);
    UF findBySigla(String sigla);
    UF findByCodigoUF(long codigoUF);


    boolean existsBySigla(String sigla);
    boolean existsByNome(String nome);
}
