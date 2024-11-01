package apisquadra.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigoUF;
    private String sigla;
    private String nome;
    private int status;

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public long getCodigoUF() {
        return codigoUF;
    }

    public void setCodigoUF(long codigoUF) {
        this.codigoUF = codigoUF;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
