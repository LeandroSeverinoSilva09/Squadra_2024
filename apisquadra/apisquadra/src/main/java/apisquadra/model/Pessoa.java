package apisquadra.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
    @SequenceGenerator(name = "pessoa_seq", sequenceName = "SEQUENCE_PESSOA", allocationSize = 1)
    @Column(name = "CODIGO_PESSOA", nullable = false)
    private Long codigoPessoa;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SOBRENOME")
    private String sobrenome;

    @Column(name = "IDADE")
    private int idade;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "STATUS")
    private int status;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Endereco> enderecos = new ArrayList<>();


}
