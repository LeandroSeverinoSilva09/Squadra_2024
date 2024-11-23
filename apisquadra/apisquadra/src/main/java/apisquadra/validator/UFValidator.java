package apisquadra.validator;

import apisquadra.exceptions.ExceptionPersonalizada;
import apisquadra.exceptions.RegistroExistente;
import apisquadra.model.UF;
import apisquadra.repository.UFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UFValidator {

    @Autowired
    private UFRepository sqlUF;


    public boolean existeUFCadastradaNomeSigla (UF uf){
        return sqlUF.existsByNome(uf.getSigla()) || sqlUF.existsBySigla(uf.getSigla());
    }

    public boolean existeUFCodigoUF (long codigoUF){
        return sqlUF.existsById(codigoUF);
    }
}
