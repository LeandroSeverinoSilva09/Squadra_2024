package apisquadra.controller;

import apisquadra.DTO.Endereco;
import apisquadra.DTO.Pessoa;
import apisquadra.DTO.UF;
import apisquadra.repository.EnderecoRepository;
import apisquadra.repository.PessoaRepository;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository sqlPessoa;


    @PostMapping()
    public ResponseEntity salvar (@RequestBody Pessoa pessoa){
        List<Endereco> enderecos = new ArrayList<>();
        System.out.println(pessoa.getEnderecos());
        enderecos = pessoa.getEnderecos();

        for (Endereco endereco : enderecos){
            endereco.setPessoa(pessoa);
            System.out.println(endereco.getCodigoBairro());

        }
        sqlPessoa.save(pessoa);
        return new ResponseEntity<>(sqlPessoa.findAll(), HttpStatus.OK);
    }

}
