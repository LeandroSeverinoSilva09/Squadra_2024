package apisquadra.controller;

import apisquadra.dto.MunicipioDTO;
import apisquadra.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
