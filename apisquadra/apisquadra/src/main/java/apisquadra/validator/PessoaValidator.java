package apisquadra.validator;

import apisquadra.exceptions.RegistroExistente;
import apisquadra.model.Pessoa;
import apisquadra.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PessoaValidator {

    @Autowired
    private PessoaRepository sqlpessoa;

    public boolean existePessoaLogin (Pessoa pessoa){
        return sqlpessoa.existsByLogin(pessoa.getLogin());
    }

    public boolean existePessoaCodigoPessoa(long codigoPessoa){
        return sqlpessoa.existsById(codigoPessoa);
    }
}
