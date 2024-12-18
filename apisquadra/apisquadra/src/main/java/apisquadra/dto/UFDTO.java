package apisquadra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UFDTO {

    private Long codigoUF;

    private String sigla;

    private String nome;

    private int status;
}
