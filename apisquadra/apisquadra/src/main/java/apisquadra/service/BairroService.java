package apisquadra.service;

import apisquadra.DTO.BairroDTO;
import apisquadra.DTO.BairroDTO;
import apisquadra.model.Bairro;
import apisquadra.model.Bairro;
import apisquadra.repository.BairroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BairroService {

    @Autowired
    private BairroRepository sqlBairro;

    public List<BairroDTO> salvarBairro (BairroDTO bairroDTO){
        Bairro bairro = new Bairro(
                bairroDTO.getCodigoBairro(),
                bairroDTO.getCodigoMunicipio(),
                bairroDTO.getNome(),
                bairroDTO.getStatus()
        );

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
