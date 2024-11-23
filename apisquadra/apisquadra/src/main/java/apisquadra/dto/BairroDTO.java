package apisquadra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BairroDTO {

    private Long codigoBairro;

    private Long codigoMunicipio;

    private String nome;

    private int status;




}
