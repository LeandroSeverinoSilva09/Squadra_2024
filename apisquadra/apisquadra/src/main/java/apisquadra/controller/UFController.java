package apisquadra.controller;

import apisquadra.dto.UFDTO;
import apisquadra.model.UF;
import apisquadra.service.UFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/uf")
public class UFController {
    @Autowired
    private UFService ufService;

    @PostMapping()
    public ResponseEntity salvar (@RequestBody UFDTO ufdto){

        List<UFDTO> ufs = ufService.salvarUF(ufdto);

        return new ResponseEntity(ufs, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity pesquisar (
            @RequestParam(required = false) Long codigoUF,
            @RequestParam(required = false) String sigla,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Integer status){

        List<UFDTO> listaUFDTO = new ArrayList<>();
        if (status != null) {
            listaUFDTO = ufService.buscarUFComStatus(codigoUF, sigla, nome, status);
            return new ResponseEntity(listaUFDTO, HttpStatus.OK);

        } else if (sigla!=null || nome!=null || codigoUF!=null){
            UFDTO ufDTOResposta = ufService.buscarUFSemStatus(codigoUF, sigla, nome);
            return new ResponseEntity(ufDTOResposta, HttpStatus.OK);

        }

        return new ResponseEntity(listaUFDTO, HttpStatus.OK);

    }

    @PutMapping()
    public ResponseEntity alterar (@RequestBody UFDTO ufdto){

        List<UFDTO> ufs = ufService.alterarUF(ufdto);

        return new ResponseEntity(ufs, HttpStatus.OK);

    }
}
