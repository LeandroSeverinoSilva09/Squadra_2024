package apisquadra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoExtendsDTO extends EnderecoDTO{

    private BairroExtendsDTO bairro;
}
