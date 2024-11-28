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
@Table(name = "TB_MUNICIPIO")
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "municipio_seq")
    @SequenceGenerator(name = "municipio_seq", sequenceName = "SEQUENCE_MUNICIPIO", allocationSize = 1)
    @Column(name = "CODIGO_MUNICIPIO", nullable = false)
    private Long codigoMunicipio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CODIGO_UF")
    private UF uf;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "STATUS")
    private int status;



}
