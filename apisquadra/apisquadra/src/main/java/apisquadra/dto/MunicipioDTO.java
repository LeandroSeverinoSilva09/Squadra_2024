package apisquadra.dto;


import apisquadra.model.UF;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MunicipioDTO {

    private Long codigoMunicipio;

    private Long codigoUF;

    private String nome;

    private int status;

}
