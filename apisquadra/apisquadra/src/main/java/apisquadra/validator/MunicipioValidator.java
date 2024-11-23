package apisquadra.validator;

import apisquadra.exceptions.RegistroExistente;
import apisquadra.model.Bairro;
import apisquadra.model.Municipio;
import apisquadra.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MunicipioValidator {

    @Autowired
    private MunicipioRepository sqlMunicipio;

    public boolean existeMunicipioCadastrado(Municipio municipio){
        return sqlMunicipio.existsByNome(municipio.getNome());
    }


    public boolean existeMunicipioCodigoMunicipio (long codigoMunicipio){
        return sqlMunicipio.existsById(codigoMunicipio);
    }
}
