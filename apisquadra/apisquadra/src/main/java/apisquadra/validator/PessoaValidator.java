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

    public void existePessoaCadastrada (Pessoa pessoa){
        if (sqlpessoa.existsByLogin(pessoa.getLogin())){
            throw new RegistroExistente("Não foi possivél cadastrar a pessoa no banco de dados");
        }
    }
}
