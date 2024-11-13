package apisquadra.dto;

import apisquadra.model.Endereco;
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
public class PessoaDTO {
    private long codigoPessoa;

    private String nome;

    private String sobrenome;

    private int idade;

    private String login;

    private String senha;

    private int status;

    private List<Endereco> enderecos = new ArrayList<>();

}
