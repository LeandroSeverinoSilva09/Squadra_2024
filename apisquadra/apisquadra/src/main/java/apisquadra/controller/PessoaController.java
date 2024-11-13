package apisquadra.controller;

import apisquadra.dto.PessoaDTO;
import apisquadra.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;


    @PostMapping()
    public ResponseEntity salvar (@RequestBody PessoaDTO pessoaDTO){
        List<PessoaDTO> pessoas = pessoaService.salvarPessoa(pessoaDTO);

        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

}
