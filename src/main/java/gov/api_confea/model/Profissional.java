package gov.api_confea.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_profissionais")
public class Profissional extends Usuario {

    @Id
    @GeneratedValue
    private Long rnp;

    @Column(nullable = false, length = 40, name="num_registro_crea")
    private String numRegistroCrea;

    @Enumerated
    @Column(nullable = false, name="tipo_numero_carteira")
    private TipoNumeroCarteira tipoNumeroCarteira;

    @Enumerated
    @Column(nullable = false, name="estado_civil")
    private EstadoCivil estadoCivil;

    @Enumerated
    @Column(name="tipo_sanguineo")
    private TipoSanguineo tipoSanguineo;

    @Enumerated
    @Column(name="fator_rh")
    private FatorRh fatorRh;

    @Column(name="doador_orgaos")
    private Boolean doadorOrgaos;

    private String website;

    @Column(nullable = false, name="nome_mae")
    private String nomeMae;

    @Column(name="nome_pai")
    private String nomePai;

    @OneToOne(optional = true)
    @JoinColumn(name = "codigo_titulo_eleitoral", referencedColumnName = "codigo")
    private TituloEleitoral tituloEleitoral;

    @OneToOne(optional = true)
    @JoinColumn(name = "id_vinculo", referencedColumnName = "id")
    private Vinculo vinculo;

    @OneToOne(mappedBy = "profissional", cascade = CascadeType.ALL)
    @JoinColumn(name = "codigo", referencedColumnName = "codigo")
    private Carteira carteira;


    // Getters and Setters

    public Long getRnp() {
        return rnp;
    }

    public String getNumRegistroCrea() {
        return numRegistroCrea;
    }

    public void setNumRegistroCrea(String numRegistroCrea) {
        this.numRegistroCrea = numRegistroCrea;
    }

    public TipoNumeroCarteira getTipoNumeroCarteira() {
        return tipoNumeroCarteira;
    }

    public void setTipoNumeroCarteira(TipoNumeroCarteira tipoNumeroCarteira) {
        this.tipoNumeroCarteira = tipoNumeroCarteira;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public FatorRh getFatorRh() {
        return fatorRh;
    }

    public void setFatorRh(FatorRh fatorRh) {
        this.fatorRh = fatorRh;
    }

    public Boolean getDoadorOrgaos() {
        return doadorOrgaos;
    }

    public void setDoadorOrgaos(Boolean doadorOrgaos) {
        this.doadorOrgaos = doadorOrgaos;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public TituloEleitoral getTituloEleitoral() {
        return tituloEleitoral;
    }

    public void setTituloEleitoral(TituloEleitoral tituloEleitoral) {
        this.tituloEleitoral = tituloEleitoral;
    }

    public Vinculo getVinculo() {
        return vinculo;
    }

    public void setVinculo(Vinculo vinculo) {
        this.vinculo = vinculo;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }
}

// Revisar enums

enum TipoNumeroCarteira {
    CREA,
    CAU
}

enum EstadoCivil {
    SOLTEIRO,
    CASADO,
    DIVORCIADO,
    VIUVO
}

enum TipoSanguineo {
    A,
    B,
    AB,
    O
}

enum FatorRh {
    POSITIVO,
    NEGATIVO
}
