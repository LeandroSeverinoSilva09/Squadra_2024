package apisquadra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MunicipioExtendsDTO extends MunicipioDTO{
    private UFDTO UF;
}
