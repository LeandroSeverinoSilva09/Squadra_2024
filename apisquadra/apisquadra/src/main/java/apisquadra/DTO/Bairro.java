package apisquadra.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_BAIRRO")
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bairro_seq")
    @SequenceGenerator(name = "bairro_seq", sequenceName = "SEQUENCE_BAIRRO", allocationSize = 1)
    private long codigoBairro;

    private long codigoMunicipio;
    private String nome;
    private int status;

}