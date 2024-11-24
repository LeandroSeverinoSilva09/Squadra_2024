package apisquadra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaRespostaDTO {

    private Long codigoPessoa;

    private String nome;

    private String sobrenome;

    private int idade;

    private String login;

    private String senha;

    private int status;

    private List<EnderecoExtendsDTO> enderecos;



}
