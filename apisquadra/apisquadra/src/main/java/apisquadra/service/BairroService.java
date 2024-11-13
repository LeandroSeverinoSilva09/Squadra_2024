package apisquadra.service;

import apisquadra.dto.BairroDTO;
import apisquadra.model.Bairro;
import apisquadra.repository.BairroRepository;
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

    public List<BairroDTO> salvarBairro (BairroDTO bairroDTO){
        Bairro bairro = new Bairro(
                bairroDTO.getCodigoBairro(),
                bairroDTO.getCodigoMunicipio(),
                bairroDTO.getNome(),
                bairroDTO.getStatus()
        );

        validatorBairro.existeBairroCadastrado(bairro);
        sqlBairro.save(bairro);
        List<BairroDTO> listaBairroDTO = new ArrayList<>();

        for (Bairro bairroSalvoConsulta : sqlBairro.findAll(Sort.by(Sort.Order.desc("codigoBairro"))) ){
            BairroDTO bairroDTOResposta = new BairroDTO();
            BeanUtils.copyProperties(bairroSalvoConsulta, bairroDTOResposta);
            listaBairroDTO.add(bairroDTOResposta);
        }
    return listaBairroDTO;
    }


}
