package apisquadra.controller;

import apisquadra.model.Municipio;
import apisquadra.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/municipio")
public class MunicipioController {

    @Autowired
    private MunicipioRepository sqlMunicipio;

    @PostMapping()
    public ResponseEntity salvar (@RequestBody Municipio municipio){
        sqlMunicipio.save(municipio);
        return new ResponseEntity(municipio, HttpStatus.OK);
    }
}
