package apisquadra.validator;

import apisquadra.model.Bairro;
import apisquadra.repository.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BairroValidator {

    @Autowired
    private BairroRepository sqlBairro;

    public void existeBairroCadastrado (Bairro bairro){
        if (sqlBairro.existsByCodigoMunicipio(bairro.getCodigoMunicipio()) || sqlBairro.existsByNome(bairro.getNome())){
            throw new RuntimeException("Não foi possível incluir bairro no banco de dados.");
        }
    }
}
