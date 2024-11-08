package apisquadra.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigoPessoa;

    private String nome;

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<String> getEndereços() {
        return endereços;
    }

    public void setEndereços(ArrayList<String> endereços) {
        this.endereços = endereços;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(long codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    private String sobrenome;
    private int idade;
    private String login;
    private String senha;
    private int status;
    private ArrayList<String> endereços;


}
