package apisquadra.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MunicipioDTO {

    private long codigoMunicipio;

    private long codigoUF;

    private String nome;

    private int status;

}
