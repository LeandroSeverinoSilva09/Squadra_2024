package apisquadra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "TB_BAIRRO")
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bairro_seq")
    @SequenceGenerator(name = "bairro_seq", sequenceName = "SEQUENCE_BAIRRO", allocationSize = 1)
    @Column(name = "CODIGO_BAIRRO")
    private long codigoBairro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CODIGO_MUNICIPIO", nullable = false)
    //@JsonIgnore
    //@Column(name = "CODIGO_MUNICIPIO")
   // private long codigoMunicipio;
    private Municipio municipio;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "STATUS")
    private int status;

}