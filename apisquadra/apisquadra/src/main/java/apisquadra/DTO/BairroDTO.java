package apisquadra.DTO;

import apisquadra.model.Bairro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BairroDTO {

    private long codigoBairro;

    private long codigoMunicipio;

    private String nome;

    private int status;

}
