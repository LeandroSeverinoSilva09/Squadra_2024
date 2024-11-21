package apisquadra.repository;


import apisquadra.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long> {


    boolean existsByNome(String nome);
    Municipio findByCodigoMunicipio(long codigoMunucipio);

    @Query("SELECT m FROM Municipio m WHERE " +
            "( :codigoMunicipio IS NULL OR m.codigoMunicipio = :codigoMunicipio ) AND " +
            "( :codigoUF IS NULL OR m.uf.codigoUF = :codigoUF ) AND " +
            "( :nome IS NULL OR m.nome = :nome )")
    Municipio findByMunicipioSemStatus(@Param("codigoMunicipio") Long codigoMunicipio,
                                       @Param("codigoUF") Long codigoUF,
                                       @Param("nome") String nome);

    @Query("SELECT m FROM Municipio m WHERE " +
            "( :codigoMunicipio IS NULL OR m.codigoMunicipio = :codigoMunicipio ) AND " +
            "( :codigoUF IS NULL OR m.uf.codigoUF = :codigoUF ) AND " +
            "( :nome IS NULL OR m.nome = :nome ) AND " +
            "( :status IS NULL OR m.status = :status )")
    List<Municipio> findByMunicipioComStatus(@Param("codigoMunicipio") Long codigoMunicipio,
                                             @Param("codigoUF") Long codigoUF,
                                             @Param("nome") String nome,
                                             @Param("status") Integer status);



}
