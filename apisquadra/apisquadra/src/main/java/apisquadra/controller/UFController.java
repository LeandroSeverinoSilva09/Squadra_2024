package apisquadra.controller;

import apisquadra.DTO.UFDTO;
import apisquadra.model.UF;
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
    
}
