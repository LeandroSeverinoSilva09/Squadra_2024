package apisquadra.service;

import apisquadra.dto.UFDTO;
import apisquadra.model.UF;
import apisquadra.repository.UFRepository;
import apisquadra.validator.UFValidator;
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
    @Autowired
    private UFValidator validatorUF;

    public List<UFDTO> salvarUF (UFDTO ufdto){
        UF uf = new UF(
                ufdto.getCodigoUF(),
                ufdto.getSigla(),
                ufdto.getNome(),
                ufdto.getStatus()
        ); // uf model foi criada a partir do DTO que é o Json
        List<UFDTO> listaUFDTO = new ArrayList<>();

        validatorUF.existeUFCadastrada(uf);
        sqlUF.save(uf);


        for (UF UFSalvoConsulta : sqlUF.findAll(Sort.by(Sort.Order.desc("codigoUF"))) ){
            UFDTO ufDTOResposta = new UFDTO();
            BeanUtils.copyProperties(UFSalvoConsulta, ufDTOResposta);
            listaUFDTO.add(ufDTOResposta);
        }
        return listaUFDTO;// repository(sql) salva a entidade



    }


    public List<UFDTO> buscarUFComStatus(Long codigoUF, String sigla, String nome, Integer status){
        List<UFDTO> listaUFDTO = new ArrayList<>();

        for (UF ufResposta : sqlUF.findByUFComStatus(codigoUF, sigla, nome, status)){
            UFDTO ufDTOResposta = new UFDTO();
            BeanUtils.copyProperties(ufResposta, ufDTOResposta);
            listaUFDTO.add(ufDTOResposta);
        }

        return listaUFDTO;
    }

    public UFDTO buscarUFSemStatus(Long codigoUF, String sigla, String nome){
        UFDTO ufDTOResposta = new UFDTO();
        UF ufresposta = sqlUF.findByUFSemStatus(codigoUF, sigla, nome);
        BeanUtils.copyProperties(ufresposta, ufDTOResposta);
        return ufDTOResposta;

    }

    public List<UFDTO> buscarListaUF (int status){

        List<UFDTO> listaUFDTO = new ArrayList<>();
        UFDTO ufDTOResposta = new UFDTO();

        for (UF ufResposta : sqlUF.findByStatus(status) ){
            BeanUtils.copyProperties(ufResposta, ufDTOResposta);
            listaUFDTO.add(ufDTOResposta);
        }
        return listaUFDTO;
    }


}
