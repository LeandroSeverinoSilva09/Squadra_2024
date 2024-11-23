package apisquadra.validator;

import apisquadra.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoValidator {
    @Autowired
    private EnderecoRepository sqlendereco;

    public boolean existeEnderecoCodigoEndereco(long codigoEndereco){
        return sqlendereco.existsById(codigoEndereco);
    }
}
