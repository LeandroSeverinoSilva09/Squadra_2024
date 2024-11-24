package apisquadra.dto;

import apisquadra.model.Bairro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    private Long codigoPessoa;

    private Long codigoEndereco;

    private Long codigoBairro;

    private String nomeRua;

    private String numero;

    private String complemento;

    private String cep;

}
