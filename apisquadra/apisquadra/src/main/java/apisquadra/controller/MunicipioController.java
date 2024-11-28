package apisquadra.controller;

import apisquadra.dto.BairroDTO;
import apisquadra.dto.MunicipioDTO;
import apisquadra.dto.MunicipioDTO;
import apisquadra.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/municipio")
public class MunicipioController {

    @Autowired
    private MunicipioService municipioService;

    @PostMapping()
    public ResponseEntity salvar (@RequestBody MunicipioDTO municipioDTO){

        List<MunicipioDTO> municipios = municipioService.salvarMunicipio(municipioDTO);

        return new ResponseEntity(municipios, HttpStatus.OK);

    }


    @GetMapping()
    public ResponseEntity pesquisar (
            @RequestParam(required = false) Long codigoMunicipio,
            @RequestParam(required = false) Long codigoUF,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Integer status){

        List<MunicipioDTO> listaMunicipioDTO = new ArrayList<>();
        try {
            if ((status != null || nome != null || codigoUF != null) && codigoMunicipio == null) {
                listaMunicipioDTO = municipioService.buscarListaMunicipio(status, codigoUF, nome);
                return new ResponseEntity(listaMunicipioDTO, HttpStatus.OK);

            } else if (codigoMunicipio != null) {
                MunicipioDTO MunicipioDTOResposta = municipioService.buscarMunicipio(codigoMunicipio, codigoUF, nome, status);
                return new ResponseEntity(MunicipioDTOResposta, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity(listaMunicipioDTO, HttpStatus.OK);
        }

        return new ResponseEntity(municipioService.buscarTodosMunicipios(), HttpStatus.OK);

    }


    @PutMapping()
    public ResponseEntity alterar (@RequestBody MunicipioDTO municipioDTO){
        List<MunicipioDTO> municipios = municipioService.alterarMunicipio(municipioDTO);

        return new ResponseEntity(municipios, HttpStatus.OK);


    }
}
