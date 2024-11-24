package apisquadra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TB_UF")
public class UF {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UF_seq")
    @SequenceGenerator(name = "UF_seq", sequenceName = "SEQUENCE_UF", allocationSize = 1)
    @Column(name = "CODIGO_UF")
    private Long codigoUF;

    @Column(name = "SIGLA")
    private String sigla;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "STATUS")
    private int status;

}
