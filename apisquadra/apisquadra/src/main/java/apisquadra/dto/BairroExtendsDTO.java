package apisquadra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BairroExtendsDTO extends BairroDTO{

    private MunicipioExtendsDTO municipio;

}
