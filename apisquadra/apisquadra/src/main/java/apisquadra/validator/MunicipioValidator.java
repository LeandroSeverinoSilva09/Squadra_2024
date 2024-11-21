package apisquadra.validator;

import apisquadra.exceptions.RegistroExistente;
import apisquadra.model.Municipio;
import apisquadra.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MunicipioValidator {

    @Autowired
    private MunicipioRepository sqlMunicipio;

    public void existeMunicioCadastrado(Municipio municipio){
        if (sqlMunicipio.existsByNome(municipio.getNome())){
            throw new RegistroExistente("Municpio já cadastrado.");
        }
    }
}
