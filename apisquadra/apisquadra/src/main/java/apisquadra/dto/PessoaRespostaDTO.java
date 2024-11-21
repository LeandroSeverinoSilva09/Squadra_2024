package apisquadra.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class PessoaExtendDTO extends PessoaDTO{

    public PessoaExtendDTO(long codigoPessoa, String nome, String sobrenome, int idade, String login, String senha, int status, List<EnderecoDTO> enderecos, List<EnderecoExtendsDTO> enderecosExtendsDTO) {
        super(codigoPessoa, nome, sobrenome, idade, login, senha, status, enderecos);
        this.enderecosExtendsDTO = enderecosExtendsDTO;
    }

    private List<EnderecoExtendsDTO> enderecosExtendsDTO;



}
