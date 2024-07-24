package gov.api_confea.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_titulos_eleitorais")
public class TituloEleitoral {

    @Id
    @Column(unique = true, nullable = false)
    private Long codigo;

    private String zona;
    private String secao;
    private String municipio;
    private String uf;

    @OneToOne
    @JoinColumn(name = "profissional_id") // Ensure this column name matches the actual foreign key column name in your database schema
    private Profissional profissional;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }
}
