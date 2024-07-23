package gov.api_confea.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_carteiras")
public class Carteira {

    @Id
    @Column(nullable = false, name = "codigo")
    private Long codigo;

    @Column(name = "data_devolucao")
    private Date dataDevolucao;

    @Column(name = "data_entrega")
    private Date dataEntrega;

    @Column(name = "data_validade")
    private Date dataValidade;

    @Column(name = "indicacao_devolucao")
    private Boolean indicacaoDevolucao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_situacao", nullable = false)
    private StatusSituacao statusSituacao;

    @Column(name = "justificativa_cancelamento")
    private String justificativaCancelamento;

    @Column(name = "motivos_cancelamento")
    private String motivosCancelamento;

    @Column(name = "codigo_reemissao")
    private String codigoReemissao;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "uf_crea_vinculado")
    private String ufCreaVinculado;

    @Column(name = "nacionalidade_profissional")
    private String nacionalidadeProfissional;

    @Column(name = "naturalidade_profissional")
    private String naturalidadeProfissional;

    @Column(name = "nome_pai")
    private String nomePai;

    @Column(name = "nome_mae")
    private String nomeMae;

    @Column(name = "nome_social")
    private String nomeSocial;

    @Column(name = "num_pis_pasep")
    private String numPisPasep;

    @OneToOne(optional = false)
    @JoinColumn(name = "rnp_profissional", referencedColumnName = "rnp")
    private Profissional profissional;

    protected Carteira() {
    }

    public Carteira(Long codigo, StatusSituacao statusSituacao, Profissional profissional) {
        this.codigo = codigo;
        this.statusSituacao = statusSituacao;
        this.profissional = profissional;
    }

    // Getters and Setters

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Boolean getIndicacaoDevolucao() {
        return indicacaoDevolucao;
    }

    public void setIndicacaoDevolucao(Boolean indicacaoDevolucao) {
        this.indicacaoDevolucao = indicacaoDevolucao;
    }

    public StatusSituacao getStatusSituacao() {
        return statusSituacao;
    }

    public void setStatusSituacao(StatusSituacao statusSituacao) {
        this.statusSituacao = statusSituacao;
    }

    public String getJustificativaCancelamento() {
        return justificativaCancelamento;
    }

    public void setJustificativaCancelamento(String justificativaCancelamento) {
        this.justificativaCancelamento = justificativaCancelamento;
    }

    public String getMotivosCancelamento() {
        return motivosCancelamento;
    }

    public void setMotivosCancelamento(String motivosCancelamento) {
        this.motivosCancelamento = motivosCancelamento;
    }

    public String getCodigoReemissao() {
        return codigoReemissao;
    }

    public void setCodigoReemissao(String codigoReemissao) {
        this.codigoReemissao = codigoReemissao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUfCreaVinculado() {
        return ufCreaVinculado;
    }

    public void setUfCreaVinculado(String ufCreaVinculado) {
        this.ufCreaVinculado = ufCreaVinculado;
    }

    public String getNacionalidadeProfissional() {
        return nacionalidadeProfissional;
    }

    public void setNacionalidadeProfissional(String nacionalidadeProfissional) {
        this.nacionalidadeProfissional = nacionalidadeProfissional;
    }

    public String getNaturalidadeProfissional() {
        return naturalidadeProfissional;
    }

    public void setNaturalidadeProfissional(String naturalidadeProfissional) {
        this.naturalidadeProfissional = naturalidadeProfissional;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getNumPisPasep() {
        return numPisPasep;
    }

    public void setNumPisPasep(String numPisPasep) {
        this.numPisPasep = numPisPasep;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }
}

enum StatusSituacao {
    ATIVA, INATIVA, CANCELADA, SUSPENSA
}