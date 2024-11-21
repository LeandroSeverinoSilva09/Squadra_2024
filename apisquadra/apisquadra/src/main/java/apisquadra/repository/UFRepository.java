package apisquadra.repository;

import apisquadra.model.UF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface UFRepository extends JpaRepository<UF, Long> {

    List<UF> findByStatus(int status);
    UF findByNome(String nome);
    UF findBySigla(String sigla);
    UF findByCodigoUF(long codigoUF);

    @Query("SELECT u FROM UF u WHERE " +
            "( :codigoUF IS NULL OR u.codigoUF = :codigoUF ) AND " +
            "( :sigla IS NULL OR u.sigla = :sigla ) AND " +
            "( :nome IS NULL OR u.nome = :nome ) ")
    UF findByUFSemStatus(@Param("codigoUF") Long codigoUF,
                              @Param("sigla") String sigla,
                              @Param("nome") String nome);

    @Query("SELECT u FROM UF u WHERE " +
            "( :codigoUF IS NULL OR u.codigoUF = :codigoUF ) AND " +
            "( :sigla IS NULL OR u.sigla = :sigla ) AND " +
            "( :nome IS NULL OR u.nome = :nome ) AND " +
            "( :status IS NULL OR u.status = :status )")
    List<UF> findByUFComStatus(@Param("codigoUF") Long codigoUF,
                         @Param("sigla") String sigla,
                         @Param("nome") String nome,
                         @Param("status") Integer status);

    boolean existsBySigla(String sigla);
    boolean existsByNome(String nome);
}
