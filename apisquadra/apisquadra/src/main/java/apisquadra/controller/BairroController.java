package apisquadra.controller;

import apisquadra.dto.BairroDTO;

import apisquadra.service.BairroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bairro")
public class BairroController {

    @Autowired
    private BairroService bairroService;

    @PostMapping()
    public ResponseEntity salvar (@RequestBody BairroDTO bairroDTO){
        List<BairroDTO> bairros = bairroService.salvarBairro(bairroDTO);

        return new ResponseEntity(bairros, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity pesquisar(
            @RequestParam(required = false) Long codigoBairro,
            @RequestParam(required = false) Long codigoMunicipio,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Integer status){

        List<BairroDTO> listaBairroDTO = new ArrayList<>();
        try {
            if ((status != null || codigoMunicipio != null || nome != null) && codigoBairro == null) {
                listaBairroDTO = bairroService.buscarBairroComStatus(codigoBairro, codigoMunicipio, nome, status);
                return new ResponseEntity(listaBairroDTO, HttpStatus.OK);

            } else if (codigoBairro != null) {
                BairroDTO bairroDTOResposta = bairroService.buscarBairroSemStatus(codigoBairro, codigoMunicipio, nome);
                return new ResponseEntity(bairroDTOResposta, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity(listaBairroDTO, HttpStatus.OK);
        }
        listaBairroDTO = bairroService.buscarBairro();
        return new ResponseEntity(listaBairroDTO, HttpStatus.OK);

    }


    @PutMapping()
    public ResponseEntity alterar (@RequestBody BairroDTO bairroDTO){
        List<BairroDTO> bairros = bairroService.alterarBairro(bairroDTO);

        return new ResponseEntity(bairros, HttpStatus.OK);

    }






}
