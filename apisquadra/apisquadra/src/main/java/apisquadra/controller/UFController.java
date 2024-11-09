package apisquadra.controller;

import apisquadra.model.UF;
import apisquadra.repository.UFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uf")
public class UFController {

    @Autowired
    private UFRepository sqlUF;

    @PostMapping()
    public ResponseEntity salvar (@RequestBody UF uf){
        sqlUF.save(uf);
        return new ResponseEntity(uf, HttpStatus.OK);
    }
}
