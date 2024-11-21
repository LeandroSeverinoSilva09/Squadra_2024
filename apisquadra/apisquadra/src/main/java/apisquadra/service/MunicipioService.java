package apisquadra.service;

import apisquadra.dto.MunicipioDTO;
import apisquadra.dto.UFDTO;
import apisquadra.model.Municipio;
import apisquadra.model.UF;
import apisquadra.repository.MunicipioRepository;
import apisquadra.repository.UFRepository;
import apisquadra.validator.MunicipioValidator;
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
    @Autowired
    private MunicipioValidator validatorMunicipio;
    @Autowired
    private UFRepository sqlUF;

    public List<MunicipioDTO> salvarMunicipio (MunicipioDTO municipiodto){
        Municipio municipio = new Municipio(
                municipiodto.getCodigoMunicipio(),
                sqlUF.findByCodigoUF(municipiodto.getCodigoUF()),
                municipiodto.getNome(),
                municipiodto.getStatus()
        );

        validatorMunicipio.existeMunicioCadastrado(municipio);
        sqlMunicipio.save(municipio);
        
        List<MunicipioDTO> listaMunicipioDTO = new ArrayList<>();

        for (Municipio municipioSalvoConsulta : sqlMunicipio.findAll(Sort.by(Sort.Order.desc("codigoMunicipio")))){
            //System.out.println(municipioSalvoConsulta.getUf().getCodigoUF());
            MunicipioDTO municipioDTOResposta = new MunicipioDTO();
            municipioDTOResposta.setCodigoUF(municipioSalvoConsulta.getUf().getCodigoUF());
            BeanUtils.copyProperties(municipioSalvoConsulta, municipioDTOResposta);
            listaMunicipioDTO.add(municipioDTOResposta);
        }

        return listaMunicipioDTO;
    }

    public List<MunicipioDTO> buscarMunicipioComStatus(Long codigoMunicipio, Long codigoUF, String nome, Integer status){
        List<MunicipioDTO> listaMunicipioDTO = new ArrayList<>();

        for (Municipio municipioResposta : sqlMunicipio.findByMunicipioComStatus(codigoMunicipio, codigoUF, nome, status)){
            MunicipioDTO municipioDTOResposta = new MunicipioDTO();
            BeanUtils.copyProperties(municipioResposta, municipioDTOResposta);
            municipioDTOResposta.setCodigoUF(municipioResposta.getUf().getCodigoUF());
            listaMunicipioDTO.add(municipioDTOResposta);
        }

        return listaMunicipioDTO;
    }

    public MunicipioDTO buscarMunicipioSemStatus(Long codigoMunicipio, Long codigoUF, String nome){
        MunicipioDTO municipioDTOResposta = new MunicipioDTO();
        Municipio municipioResposta = sqlMunicipio.findByMunicipioSemStatus(codigoMunicipio, codigoUF, nome);
        BeanUtils.copyProperties(municipioResposta, municipioDTOResposta);
        municipioDTOResposta.setCodigoUF(municipioResposta.getUf().getCodigoUF());
        return municipioDTOResposta;

    }
}
