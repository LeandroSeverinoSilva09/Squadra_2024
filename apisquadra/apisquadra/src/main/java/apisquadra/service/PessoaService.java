package apisquadra.service;

import apisquadra.DTO.PessoaDTO;
import apisquadra.model.Endereco;
import apisquadra.model.Pessoa;
import apisquadra.repository.EnderecoRepository;
import apisquadra.repository.PessoaRepository;
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

    public List<PessoaDTO> salvarPessoa (PessoaDTO pessoaDTO){
        /*
        Pessoa pessoa = new Pessoa(
                pessoaDTO.getCodigoPessoa(),
                pessoaDTO.getNome(),
                pessoaDTO.getSobrenome(),
                pessoaDTO.getIdade(),
                pessoaDTO.getLogin(),
                pessoaDTO.getSenha(),
                pessoaDTO.getStatus()

        );*/
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, pessoa);

        Pessoa pessoaSalva = sqlPessoa.save(pessoa);

        for (Endereco enderecoDTO : pessoaDTO.getEnderecos()){
            Endereco endereco = new Endereco(enderecoDTO.getCodigoEndereco(),
                    pessoaSalva.getCodigoPessoa(),
                    enderecoDTO.getCodigoBairro(),
                    enderecoDTO.getNomeRua(),
                    enderecoDTO.getNumero(),
                    enderecoDTO.getComplemento(),
                    enderecoDTO.getCep()
            );
            sqlEndereco.save(endereco);
        }

        List<PessoaDTO> listaPessoaDTO = new ArrayList<>();

        for (Pessoa pessoaSalvaConsulta : sqlPessoa.findAll(Sort.by(Sort.Order.desc("codigoPessoa"))) ){
            PessoaDTO pessoaDTOResposta = new PessoaDTO(/*pessoaSalvaConsulta.getCodigoPessoa(),
                    pessoaSalvaConsulta.getNome(),
                    pessoaSalvaConsulta.getSobrenome(),
                    pessoaSalvaConsulta.getIdade(),
                    pessoaSalvaConsulta.getLogin(),
                    pessoaSalvaConsulta.getSenha(),
                    pessoaSalvaConsulta.getStatus(),
            */);

            BeanUtils.copyProperties(pessoaSalvaConsulta, pessoaDTOResposta);
            listaPessoaDTO.add(pessoaDTOResposta);

        }

        return listaPessoaDTO;//sqlPessoa.findAll(Sort.by(Sort.Order.desc("codigoPessoa")));
    }
}
