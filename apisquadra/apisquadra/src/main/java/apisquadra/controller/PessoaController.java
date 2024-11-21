package apisquadra.controller;

import apisquadra.dto.PessoaDTO;
import apisquadra.dto.PessoaRespostaDTO;
import apisquadra.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;


    @PostMapping()
    public ResponseEntity salvar (@RequestBody PessoaDTO pessoaDTO){
        List<PessoaDTO> pessoas = pessoaService.salvarPessoa(pessoaDTO);

        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity buscar (
            @RequestParam(required = false) Long codigoPessoa,
            @RequestParam(required = false) String login,
            @RequestParam(required = false) Integer status){
        if (codigoPessoa!=null){
            PessoaRespostaDTO pessoaRespostaDTO = pessoaService.buscarPessoaCodigo(codigoPessoa);
            return new ResponseEntity<>(pessoaRespostaDTO, HttpStatus.OK);
        } else if(status!=null && login == null){
            List<PessoaDTO> pessoasDTO = pessoaService.buscarPessoaStatus(status);
            return new ResponseEntity<>(pessoasDTO, HttpStatus.OK);
        } else {
            PessoaDTO pessoaDTO = pessoaService.buscarPessoaLogin(login);
            return new ResponseEntity<>(pessoaDTO, HttpStatus.OK);
        }

        //return new ResponseEntity<>("", HttpStatus.OK);//findall()


    }


}
