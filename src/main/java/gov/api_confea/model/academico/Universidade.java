package gov.api_confea.model.academico;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_universidades")
public class Universidade {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String denominacao;

    @Column(nullable = false)
    private String sigla;

    @Column(name = "municipio_sede", nullable = false)
    private String municipioSede;

    @Column(nullable = false)
    private String regiao;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String telefone;
    private String site;

    @OneToMany(mappedBy = "universidade", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Curso> cursos;

    public UUID getId() {
        return id;
    }

    public String getDenominacao() {
        return denominacao;
    }

    public void setDenominacao(String denominacao) {
        this.denominacao = denominacao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getMunicipioSede() {
        return municipioSede;
    }

    public void setMunicipioSede(String municipioSede) {
        this.municipioSede = municipioSede;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
