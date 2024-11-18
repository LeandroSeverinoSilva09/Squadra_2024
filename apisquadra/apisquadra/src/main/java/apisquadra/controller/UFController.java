package apisquadra.controller;

import apisquadra.dto.UFDTO;
import apisquadra.service.UFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        List<>
        if (status != null){
            List<UFDTO> ufDTOLista = ufService.buscarListaUF(status);
            return new ResponseEntity(ufDTOLista, HttpStatus.OK);

        } else if (sigla!=null) {
            UFDTO ufDTO = ufService.buscarUFSigla(sigla);
            return new ResponseEntity(ufDTO, HttpStatus.OK);

        } else if ( nome != null ) {
            UFDTO ufDTO = ufService.buscarUFNome(nome);
            return new ResponseEntity(ufDTO, HttpStatus.OK);

        } else if (codigoUF != null) {
            UFDTO ufDTO = ufService.buscarUFCodigoUF(codigoUF);
            return new ResponseEntity(ufDTO, HttpStatus.OK);
        }
        return new ResponseEntity("", HttpStatus.OK);

    }
}
