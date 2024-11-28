package apisquadra.controller;

import apisquadra.dto.PessoaDTO;
import apisquadra.dto.PessoaRespostaDTO;
import apisquadra.dto.UFDTO;
import apisquadra.exceptions.RegistroExistente;
import apisquadra.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        List<PessoaDTO> pessoasDTO = new ArrayList<>();
        try {
            if (codigoPessoa != null) {
                PessoaRespostaDTO pessoaRespostaDTO = pessoaService.buscarPessoaCodigo(codigoPessoa);
                return new ResponseEntity<>(pessoaRespostaDTO, HttpStatus.OK);
            } else if (status != null && login == null) {
                pessoasDTO = pessoaService.buscarPessoaStatus(status);
                return new ResponseEntity<>(pessoasDTO, HttpStatus.OK);
            } else if (login != null && status == null) {
                pessoasDTO = pessoaService.buscarPessoaLogin(login);
                return new ResponseEntity<>(pessoasDTO, HttpStatus.OK);
            } else if (login != null && status != null) {
                throw new RegistroExistente("Não foi possivél consultar a pesoa no banco de dados, existe mais de um parametro paera pesquisa");
            }
        } catch (Exception e) {
            return new ResponseEntity<>(pessoasDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(pessoaService.buscarPessoas(), HttpStatus.OK);//findall()


    }

    @PutMapping()
    public ResponseEntity alterar (@RequestBody PessoaDTO pessoaDTO){

        List<PessoaDTO> pessoasDTO = pessoaService.alterar(pessoaDTO);

        return new ResponseEntity(pessoasDTO, HttpStatus.OK);

    }


}
