package apisquadra.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TB_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq")
    @SequenceGenerator(name = "endereco_seq", sequenceName = "SEQUENCE_ENDERECO", allocationSize = 1)
    @Column(name = "CODIGO_ENDERECO")
    private long codigoEndereco;

    @ManyToOne
    @JoinColumn(name = "CODIGO_PESSOA")
    @JsonBackReference
    private Pessoa pessoa;

    @Column(name = "CODIGO_BAIRRO")
    private long codigoBairro;

    @Column(name = "NOME_RUA")
    private String nomeRua;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "CEP")
    private String cep;



}
