package apisquadra.service;

import apisquadra.dto.*;
import apisquadra.model.*;
import apisquadra.repository.BairroRepository;
import apisquadra.repository.EnderecoRepository;
import apisquadra.repository.PessoaRepository;
import apisquadra.validator.PessoaValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository sqlPessoa;
    @Autowired
    private EnderecoRepository sqlEndereco;
    @Autowired
    private PessoaValidator validatorPessoa;
    @Autowired
    private BairroRepository sqlBairro;

    public List<PessoaDTO> salvarPessoa (PessoaDTO pessoaDTO){

        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, pessoa);

        validatorPessoa.existePessoaCadastrada(pessoa);
        Pessoa pessoaSalva = sqlPessoa.save(pessoa);
        for (EnderecoDTO enderecoDTO : pessoaDTO.getEnderecos()){
            Endereco endereco = new Endereco();
            BeanUtils.copyProperties(enderecoDTO, endereco);
            endereco.setPessoa(pessoaSalva);

            Bairro bairro = sqlBairro.findByCodigoBairro(enderecoDTO.getCodigoBairro());
            endereco.setBairro(bairro);

            sqlEndereco.save(endereco);
        }


        List<PessoaDTO> listaPessoaDTO = new ArrayList<>();

        for (Pessoa pessoaSalvaConsulta : sqlPessoa.findAll(Sort.by(Sort.Order.desc("codigoPessoa"))) ){
            PessoaDTO pessoaDTOResposta = new PessoaDTO();

            BeanUtils.copyProperties(pessoaSalvaConsulta, pessoaDTOResposta);
            listaPessoaDTO.add(pessoaDTOResposta);

        }

        return listaPessoaDTO;
    }

    public PessoaRespostaDTO buscarPessoaCodigo (Long codigoPessoa){

        Pessoa pessoa = sqlPessoa.findByCodigoPessoa(codigoPessoa);
        List<EnderecoExtendsDTO> enderecosExtendsDTO = new ArrayList<>();

        System.out.println(pessoa.getEnderecos());

        for (Endereco endereco : pessoa.getEnderecos()){

            UFDTO ufdto = new UFDTO();
            UF uf = endereco.getBairro().getMunicipio().getUf();
            BeanUtils.copyProperties(uf, ufdto);

            MunicipioExtendsDTO municipioExtendsDTO = new MunicipioExtendsDTO();
            Municipio municipio = endereco.getBairro().getMunicipio();
            BeanUtils.copyProperties(municipio, municipioExtendsDTO);
            municipioExtendsDTO.setUF(ufdto);
            municipioExtendsDTO.setCodigoUF(uf.getCodigoUF());

            BairroExtendsDTO bairroExtendsDTO = new BairroExtendsDTO();
            Bairro bairro = endereco.getBairro();
            BeanUtils.copyProperties(bairro, bairroExtendsDTO);
            bairroExtendsDTO.setMunicipio(municipioExtendsDTO);
            bairroExtendsDTO.setCodigoMunicipio(municipio.getCodigoMunicipio());


            EnderecoExtendsDTO enderecoExtendsDTO = new EnderecoExtendsDTO();
            BeanUtils.copyProperties(endereco, enderecoExtendsDTO);
            enderecoExtendsDTO.setBairro(bairroExtendsDTO);
            enderecoExtendsDTO.setCodigoPessoa(pessoa.getCodigoPessoa());
            enderecoExtendsDTO.setCodigoBairro(bairro.getCodigoBairro());
            enderecosExtendsDTO.add(enderecoExtendsDTO);



        }
        PessoaRespostaDTO pessoaRespostaDTO = new PessoaRespostaDTO();
        BeanUtils.copyProperties(pessoa, pessoaRespostaDTO);
        pessoaRespostaDTO.setEnderecos(enderecosExtendsDTO);


        return pessoaRespostaDTO;
    }

    public List<PessoaDTO> buscarPessoaStatus (int status){
        List<PessoaDTO> pessoasDTOSalvas = new ArrayList<>();

        for (Pessoa pessoaResposta : sqlPessoa.findByStatus(status)){
            PessoaDTO pessoaDTOResposta = new PessoaDTO();
            BeanUtils.copyProperties(pessoaResposta, pessoaDTOResposta);
            pessoasDTOSalvas.add(pessoaDTOResposta);
        }
        return pessoasDTOSalvas;


    }

    public  PessoaDTO buscarPessoaLogin(String login){
        PessoaDTO pessoaDTOResposta = new PessoaDTO();
        Pessoa pessoa = sqlPessoa.findByLogin(login);
        BeanUtils.copyProperties(pessoa, pessoaDTOResposta);
        return  pessoaDTOResposta;
    }


}
