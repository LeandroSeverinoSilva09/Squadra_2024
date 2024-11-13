package apisquadra.validator;

import apisquadra.exceptions.RegistroExistente;
import apisquadra.model.UF;
import apisquadra.repository.UFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UFValidator {

    @Autowired
    private UFRepository sqlUF;


    public void existeUFCadastrada (UF uf){
        if (sqlUF.existsByNome(uf.getSigla()) || sqlUF.existsBySigla(uf.getSigla())){
            throw new RegistroExistente("UF já cadastrada"); //Não foi possível incluir UF no banco de dados.
        }
    }
}
