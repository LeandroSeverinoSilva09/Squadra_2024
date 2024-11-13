package apisquadra.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UFDTO {
    private long codigoUF;

    private String sigla;

    private String nome;

    private int status;
}
