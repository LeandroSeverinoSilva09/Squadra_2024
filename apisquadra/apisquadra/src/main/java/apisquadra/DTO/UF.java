package apisquadra.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="TB_UF")
public class UF {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UF_seq")
    @SequenceGenerator(name = "UF_seq", sequenceName = "SEQUENCE_UF", allocationSize = 1)
    @Column(name = "CODIGO_UF")
    private long codigoUF;

    @Column(name = "SIGLA")
    private String sigla;


    private String nome;
    private int status;

}
