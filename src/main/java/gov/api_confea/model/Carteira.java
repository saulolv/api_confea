package gov.api_confea.model;

import gov.api_confea.model.academico.Titulo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_carteiras")
@Data
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

    @ManyToMany
    @JoinTable(
            name = "carteiras_titulos",
            joinColumns = @JoinColumn(name = "codigo_carteira"),
            inverseJoinColumns = @JoinColumn(name = "codigo_titulo")
    )
    private Set<Titulo> titulos = new HashSet<>();

    public Set<Titulo> getTitulos() {
        return this.titulos;
    }

    protected Carteira() {
    }

    public Carteira(Long codigo, StatusSituacao statusSituacao, Profissional profissional) {
        this.codigo = codigo;
        this.statusSituacao = statusSituacao;
        this.profissional = profissional;
    }

    public void addTitulo(Titulo titulo) {
        this.titulos.add(titulo);
        titulo.getCarteiras().add(this);
    }

    public void removeTitulo(Titulo titulo) {
        this.titulos.remove(titulo);
        titulo.getCarteiras().remove(this);
    }

}

enum StatusSituacao {
    ATIVA, INATIVA, CANCELADA, SUSPENSA
}