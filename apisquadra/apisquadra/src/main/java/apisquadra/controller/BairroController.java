package apisquadra.controller;

import apisquadra.dto.BairroDTO;
import apisquadra.service.BairroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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



}
