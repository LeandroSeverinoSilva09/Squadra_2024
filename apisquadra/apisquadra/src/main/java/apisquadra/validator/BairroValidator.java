package apisquadra.validator;

import apisquadra.model.Bairro;
import apisquadra.repository.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BairroValidator {

    @Autowired
    private BairroRepository sqlBairro;



    public boolean existeBairroCadastrado (Bairro bairro){
        return sqlBairro.existsByNome(bairro.getNome());
    }

    public boolean existeBairroCodigoBairro (long codigoBairro){
        return sqlBairro.existsById(codigoBairro);
    }
}
