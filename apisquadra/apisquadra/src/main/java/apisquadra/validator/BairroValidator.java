package apisquadra.validator;

import apisquadra.exceptions.RegistroExistente;
import apisquadra.model.Bairro;
import apisquadra.repository.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BairroValidator {

    @Autowired
    private BairroRepository sqlBairro;

    public void existeBairroCadastrado (Bairro bairro){
        if (sqlBairro.existsByNome(bairro.getNome())){
            throw new RegistroExistente("Bairro já cadastrado.");
        }
    }
}
