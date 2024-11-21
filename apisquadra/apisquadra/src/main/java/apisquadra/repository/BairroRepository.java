package apisquadra.repository;

import apisquadra.model.Bairro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {

    boolean existsByNome(String nome);
    Bairro findByCodigoBairro (long codigoBairro);


    @Query("SELECT b FROM Bairro b WHERE " +
            "( :codigoBairro IS NULL OR b.codigoBairro = :codigoBairro ) AND " +
            "( :codigoMunicipio IS NULL OR b.municipio.codigoMunicipio = :codigoMunicipio ) AND " +
            "( :nome IS NULL OR b.nome = :nome )")
    Bairro findByBairroSemStatus(@Param("codigoBairro") Long codigoBairro,
                                 @Param("codigoMunicipio") Long codigoMunicipio,
                                 @Param("nome") String nome);

    @Query("SELECT b FROM Bairro b WHERE " +
            "( :codigoBairro IS NULL OR b.codigoBairro = :codigoBairro ) AND " +
            "( :codigoMunicipio IS NULL OR b.municipio.codigoMunicipio = :codigoMunicipio ) AND " +
            "( :nome IS NULL OR b.nome = :nome ) AND " +
            "( :status IS NULL OR b.status = :status )")
    List<Bairro> findByBairroComStatus(@Param("codigoBairro") Long codigoBairro,
                                       @Param("codigoMunicipio") Long codigoMunicipio,
                                       @Param("nome") String nome,
                                       @Param("status") Integer status);


}
