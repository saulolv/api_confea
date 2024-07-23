package gov.api_confea.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_titulos_eleitorais")
public class TituloEleitoral {

    @Id
    private Long codigo;

    private String zona;
    private String secao;
    private String municipio;
    private String uf;

    // Getters and Setters


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getZona() {
        return zona;
    }

    public String getSecao() {
        return secao;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
