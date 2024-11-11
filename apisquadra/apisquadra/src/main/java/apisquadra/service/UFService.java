package apisquadra.service;

import apisquadra.DTO.UFDTO;
import apisquadra.model.UF;
import apisquadra.repository.UFRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UFService {

    @Autowired
    private UFRepository sqlUF;

    public List<UFDTO> salvarUF (UFDTO ufdto){
        UF uf = new UF(
                ufdto.getCodigoUF(),
                ufdto.getSigla(),
                ufdto.getNome(),
                ufdto.getStatus()
        ); // uf model foi criada a partir do DTO que é o Json
        
        sqlUF.save(uf); // repository(sql) salva a entidade

        List<UFDTO> listaUFDTO = new ArrayList<>();

        for (UF UFSalvoConsulta : sqlUF.findAll(Sort.by(Sort.Order.desc("codigoUF"))) ){
            UFDTO ufDTOResposta = new UFDTO();
            BeanUtils.copyProperties(UFSalvoConsulta, ufDTOResposta);
            listaUFDTO.add(ufDTOResposta);
        }
        return listaUFDTO;
    }
}
