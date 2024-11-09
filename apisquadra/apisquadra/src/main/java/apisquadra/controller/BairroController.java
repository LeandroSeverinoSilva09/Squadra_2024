package apisquadra.controller;

import apisquadra.model.Bairro;
import apisquadra.repository.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bairro")
public class BairroController {

    @Autowired
    private BairroRepository sqlBairro;

    @PostMapping()
    public ResponseEntity salvar (@RequestBody Bairro bairro){
        sqlBairro.save(bairro);
        return new ResponseEntity(bairro, HttpStatus.OK);
    }

}
