package apisquadra.service;

import apisquadra.dto.BairroDTO;
import apisquadra.dto.UFDTO;
import apisquadra.exceptions.ExceptionPersonalizada;
import apisquadra.model.Bairro;
import apisquadra.model.UF;
import apisquadra.repository.BairroRepository;
import apisquadra.repository.MunicipioRepository;
import apisquadra.validator.BairroValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BairroService {

    @Autowired
    private BairroRepository sqlBairro;
    @Autowired
    private BairroValidator validatorBairro;
    @Autowired
    private MunicipioRepository sqlMunucipio;

    public List<BairroDTO> salvarBairro (BairroDTO bairroDTO){
        Bairro bairro = new Bairro(
                bairroDTO.getCodigoBairro(),
                sqlMunucipio.findByCodigoMunicipio(bairroDTO.getCodigoMunicipio()),
                bairroDTO.getNome(),
                bairroDTO.getStatus()
        );

        if (validatorBairro.existeBairroCadastrado(bairro)){
            throw new ExceptionPersonalizada("Bairro já existente");
        };
        sqlBairro.save(bairro);
        List<BairroDTO> listaBairroDTO = new ArrayList<>();

        for (Bairro bairroSalvoConsulta : sqlBairro.findAll(Sort.by(Sort.Order.desc("codigoBairro"))) ){
            BairroDTO bairroDTOResposta = new BairroDTO();
            bairroDTOResposta.setCodigoMunicipio(bairroSalvoConsulta.getMunicipio().getCodigoMunicipio());
            BeanUtils.copyProperties(bairroSalvoConsulta, bairroDTOResposta);
            listaBairroDTO.add(bairroDTOResposta);
        }
    return listaBairroDTO;
    }

    public List<BairroDTO> buscarBairroComStatus(Long codigoBairro, Long codigoMunicipio, String nome, Integer status){
        List<BairroDTO> listaBairroDTO = new ArrayList<>();

        for (Bairro bairroResposta : sqlBairro.findByBairroComStatus(codigoBairro, codigoMunicipio, nome, status)){
            BairroDTO bairroDTOResposta = new BairroDTO();
            BeanUtils.copyProperties(bairroResposta, bairroDTOResposta);
            bairroDTOResposta.setCodigoMunicipio(bairroResposta.getMunicipio().getCodigoMunicipio());
            listaBairroDTO.add(bairroDTOResposta);
        }

        return listaBairroDTO;
    }

    public BairroDTO buscarBairroSemStatus(Long codigoBairro, Long codigoMunicipio, String nome) {
        BairroDTO bairroDTOResposta = new BairroDTO();
        Bairro bairroResposta = sqlBairro.findByBairroSemStatus(codigoBairro, codigoMunicipio, nome);
        BeanUtils.copyProperties(bairroResposta, bairroDTOResposta);
        bairroDTOResposta.setCodigoMunicipio(bairroResposta.getMunicipio().getCodigoMunicipio());
        return bairroDTOResposta;
    }

    public List<BairroDTO> alterarBairro (BairroDTO bairrodto){
        if (bairrodto.getCodigoBairro() == null){
            throw new ExceptionPersonalizada("O codigoBairro precisa ter um valor válido");
        }
        Bairro bairro = new Bairro();
        BeanUtils.copyProperties(bairrodto, bairro);

        List<BairroDTO> listaBairroDTO = new ArrayList<>();

        if (validatorBairro.existeBairroCodigoBairro(bairro.getCodigoBairro())) {
            //if (validatorBairro.existeBairroCadastrado(bairro)) {
            //    throw new ExceptionPersonalizada("Já existe outra UF com esses dados");
            //}
            sqlBairro.save(bairro);


            for (Bairro bairroSalvoConsulta : sqlBairro.findAll(Sort.by(Sort.Order.desc("codigoBairro")))) {
                BairroDTO bairroDTOResposta = new BairroDTO();
                bairroDTOResposta.setCodigoMunicipio(bairroSalvoConsulta.getMunicipio().getCodigoMunicipio());
                BeanUtils.copyProperties(bairroSalvoConsulta, bairroDTOResposta);
                listaBairroDTO.add(bairroDTOResposta);
            }

            return listaBairroDTO;

        }else{
            throw new ExceptionPersonalizada("Não existe UF com esse código " + bairro.getCodigoBairro());
        }
    }

    public List<BairroDTO> deletarBairro (BairroDTO bairroDTO){
        if (bairroDTO.getCodigoBairro() == null){
            throw new ExceptionPersonalizada("O codigoBairro precisa ter um valor válido");
        }
        Bairro bairro = new Bairro();
        BeanUtils.copyProperties(bairroDTO, bairro);

        List<BairroDTO> listaBairroDTO = new ArrayList<>();

        if (validatorBairro.existeBairroCodigoBairro(bairro.getCodigoBairro())) {

            bairro.setCodigoBairro(Long.valueOf(3));
            sqlBairro.save(bairro);

            for (Bairro bairroSalvoConsulta : sqlBairro.findAll(Sort.by(Sort.Order.desc("codigoBairro")))) {
                BairroDTO bairroDTOResposta = new BairroDTO();
                bairroDTOResposta.setCodigoMunicipio(bairroSalvoConsulta.getMunicipio().getCodigoMunicipio());
                BeanUtils.copyProperties(bairroSalvoConsulta, bairroDTOResposta);
                listaBairroDTO.add(bairroDTOResposta);
            }

            return listaBairroDTO;

        }else{
            throw new ExceptionPersonalizada("Não existe UF com esse código " + bairro.getCodigoBairro());
        }
    }





}
