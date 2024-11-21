package apisquadra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq")
    @SequenceGenerator(name = "endereco_seq", sequenceName = "SEQUENCE_ENDERECO", allocationSize = 1)
    @Column(name = "CODIGO_ENDERECO")
    private long codigoEndereco;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CODIGO_PESSOA", nullable = false)
    @JsonIgnore
    //private Pessoa pessoa;
    //@Column(name = "CODIGO_PESSOA")
    //private long codigoPessoa;
    private Pessoa pessoa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CODIGO_BAIRRO", nullable = false)
    //@Column(name = "CODIGO_BAIRRO")
    //private long codigoBairro;
    private Bairro bairro;

    @Column(name = "NOME_RUA")
    private String nomeRua;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "CEP")
    private String cep;



}
