package apisquadra.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_MUNICIPIO")
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "municipio_seq")
    @SequenceGenerator(name = "municipio_seq", sequenceName = "SEQUENCE_MUNICIPIO", allocationSize = 1)
    private long codigoMunicipio;

    @Column(name = "CODIGO_UF")
    private long codigoUF;

    private String nome;
    private int status;



}
