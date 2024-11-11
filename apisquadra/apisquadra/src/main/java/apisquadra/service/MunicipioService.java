package apisquadra.service;

import apisquadra.DTO.MunicipioDTO;
import apisquadra.DTO.MunicipioDTO;
import apisquadra.model.Municipio;
import apisquadra.model.Municipio;
import apisquadra.repository.MunicipioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MunicipioService {
    @Autowired
    private MunicipioRepository sqlMunicipio;

    public List<MunicipioDTO> salvarMunicipio (MunicipioDTO municipiodto){
        Municipio municipio = new Municipio(
                municipiodto.getCodigoMunicipio(),
                municipiodto.getCodigoUF(),
                municipiodto.getNome(),
                municipiodto.getStatus()
        );

        sqlMunicipio.save(municipio);
        
        List<MunicipioDTO> listaMunicipioDTO = new ArrayList<>();

        for (Municipio municipioSalvoConsulta : sqlMunicipio.findAll(Sort.by(Sort.Order.desc("codigoMunicipio"))) ){
            MunicipioDTO municipioDTOResposta = new MunicipioDTO();
            BeanUtils.copyProperties(municipioSalvoConsulta, municipioDTOResposta);
            listaMunicipioDTO.add(municipioDTOResposta);
        }

        return listaMunicipioDTO;
    }
}
