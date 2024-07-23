package gov.api_confea.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_enderecos")
public abstract class Endereco {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 40)
    private String nome;

    @Column(nullable = false, length = 20)
    private String cep;

    @Column(nullable = false, length = 2)
    private String uf;

    @Column(nullable = false, length = 40)
    private String cidade;

    @Column(nullable = false, length = 40)
    private String bairro;

    @Column(nullable = false, length = 50)
    private String logradouro;

    @Column(nullable = false, length = 10)
    private String numeroLogradouro;

    @Column(nullable = false, length = 20)
    private String tipoLogradouro;

    @Column(length = 40)
    private String complemento;

    @Column(length = 20)
    private String fax;

    @Column(nullable = false, name="data_criacao")
    private final LocalDateTime dataCriacao = LocalDateTime.now();


    // Getters and Setters

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroLogradouro() {
        return numeroLogradouro;
    }

    public void setNumeroLogradouro(String numeroLogradouro) {
        this.numeroLogradouro = numeroLogradouro;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
