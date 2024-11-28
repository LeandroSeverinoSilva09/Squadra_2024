package apisquadra.service;

import apisquadra.dto.MunicipioDTO;

import apisquadra.exceptions.ExceptionPersonalizada;
import apisquadra.model.Municipio;
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
        Municipio municipio = new Municipio();
        BeanUtils.copyProperties(municipiodto, municipio);
        municipio.setUf(sqlUF.findByCodigoUF(municipiodto.getCodigoUF()));

        if(validatorMunicipio.existeMunicipioCadastrado(municipio)){
            throw new ExceptionPersonalizada("Municipio já existente");
        }
        sqlMunicipio.save(municipio);
        
        List<MunicipioDTO> listaMunicipioDTO = new ArrayList<>();

        for (Municipio municipioSalvoConsulta : sqlMunicipio.findAll(Sort.by(Sort.Order.desc("codigoMunicipio")))){
            MunicipioDTO municipioDTOResposta = new MunicipioDTO();
            municipioDTOResposta.setCodigoUF(municipioSalvoConsulta.getUf().getCodigoUF());
            BeanUtils.copyProperties(municipioSalvoConsulta, municipioDTOResposta);
            listaMunicipioDTO.add(municipioDTOResposta);
        }

        return listaMunicipioDTO;
    }

    public List<MunicipioDTO> buscarListaMunicipio(Integer status, Long codigoUF, String nome){
        try {
            List<MunicipioDTO> listaMunicipioDTO = new ArrayList<>();

            for (Municipio municipioResposta : sqlMunicipio.findByListaMunicipio(status, codigoUF, nome)) {
                MunicipioDTO municipioDTOResposta = new MunicipioDTO();
                BeanUtils.copyProperties(municipioResposta, municipioDTOResposta);
                municipioDTOResposta.setCodigoUF(municipioResposta.getUf().getCodigoUF());
                listaMunicipioDTO.add(municipioDTOResposta);
            }

            return listaMunicipioDTO;
        } catch (Exception e) {
            throw new ExceptionPersonalizada("Não foi possivél Consultar o Municipio no banco de dados ");
        }
    }

    public List<MunicipioDTO> buscarTodosMunicipios(){
        try {
            List<MunicipioDTO> listaMunicipioDTO = new ArrayList<>();

            for (Municipio municipioResposta : sqlMunicipio.findAll()) {
                MunicipioDTO municipioDTOResposta = new MunicipioDTO();
                BeanUtils.copyProperties(municipioResposta, municipioDTOResposta);
                municipioDTOResposta.setCodigoUF(municipioResposta.getUf().getCodigoUF());
                listaMunicipioDTO.add(municipioDTOResposta);
            }

            return listaMunicipioDTO;
        } catch (Exception e) {
            throw new ExceptionPersonalizada("Não foi possivél Consultar o Municipio no banco de dados ");
        }
    }

    public MunicipioDTO buscarMunicipio(Long codigoMunicipio, Long codigoUF, String nome, Integer status){
        try{
            MunicipioDTO municipioDTOResposta = new MunicipioDTO();
            Municipio municipioResposta = sqlMunicipio.findByMunicipio(codigoMunicipio, codigoUF, nome, status);
            BeanUtils.copyProperties(municipioResposta, municipioDTOResposta);
            municipioDTOResposta.setCodigoUF(municipioResposta.getUf().getCodigoUF());
            return municipioDTOResposta;
        } catch (Exception e) {
            throw new ExceptionPersonalizada("Não foi possivél Consultar o Municipio no banco de dados ");
        }

    }



    public List<MunicipioDTO> alterarMunicipio (MunicipioDTO municipiodto){
        try {
            if (municipiodto.getCodigoMunicipio() == null) {
                throw new ExceptionPersonalizada("O codigoMunicipio precisa ter um valor válido");
            }
            Municipio municipio = new Municipio();
            BeanUtils.copyProperties(municipiodto, municipio);
            municipio.setUf(sqlUF.findByCodigoUF(municipiodto.getCodigoUF()));

            List<MunicipioDTO> listaMunicipioDTO = new ArrayList<>();

            if (validatorMunicipio.existeMunicipioCodigoMunicipio(municipio.getCodigoMunicipio())) {
                //System.out.println(municipio.getUf().getCodigoUF() + "============================================================");

                sqlMunicipio.save(municipio);

                for (Municipio municipioSalvoConsulta : sqlMunicipio.findAll(Sort.by(Sort.Order.desc("codigoMunicipio")))) {
                    MunicipioDTO municipioDTOResposta = new MunicipioDTO();
                    municipioDTOResposta.setCodigoUF(municipioSalvoConsulta.getUf().getCodigoUF());
                    BeanUtils.copyProperties(municipioSalvoConsulta, municipioDTOResposta);
                    listaMunicipioDTO.add(municipioDTOResposta);
                }

                return listaMunicipioDTO;

            } else {
                throw new ExceptionPersonalizada("Não existe Municipio com esse código " + municipio.getCodigoMunicipio());
            }
        } catch (Exception e) {
            throw new ExceptionPersonalizada("Não foi possivél Alterar o Municipio no banco de dados ");
        }
    }
    
    
}
