package gov.api_confea.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import gov.api_confea.model.pagamento.Anuidade;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_vinculos")
public class Vinculo {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "alteracao_rnp")
    private String alteracaoRnp;

    @Enumerated
    @Column(name = "status_rnp")
    private StatusRnp statusRnp;

    @Enumerated
    @Column(name = "tipo_registro")
    private TipoRegistro tipoRegistro;

    @Column(name = "data_validade")
    private LocalDate dataValidade;

    @Column(name = "data_ativacao")
    private LocalDateTime dataAtivacao;

    @Column(name = "data_cancelamento")
    private LocalDateTime DataCancelamento;

    @OneToMany
    @JoinColumn(name = "id_anuidade", referencedColumnName = "id")
    @JsonManagedReference
    private List<Anuidade> anuidade = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public String getAlteracaoRnp() {
        return alteracaoRnp;
    }

    public void setAlteracaoRnp(String alteracaoRnp) {
        this.alteracaoRnp = alteracaoRnp;
    }

    public StatusRnp getStatusRnp() {
        return statusRnp;
    }

    public void setStatusRnp(StatusRnp statusRnp) {
        this.statusRnp = statusRnp;
    }

    public TipoRegistro getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(TipoRegistro tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public LocalDateTime getDataAtivacao() {
        return dataAtivacao;
    }

    public void setDataAtivacao(LocalDateTime dataAtivacao) {
        this.dataAtivacao = dataAtivacao;
    }

    public LocalDateTime getDataCancelamento() {
        return DataCancelamento;
    }

    public void setDataCancelamento(LocalDateTime dataCancelamento) {
        DataCancelamento = dataCancelamento;
    }

    public List<Anuidade> getAnuidade() {
        return anuidade;
    }

    public void setAnuidade(List<Anuidade> anuidade) {
        this.anuidade = anuidade;
    }

    public void tipoRegistroRnp() {
        this.tipoRegistro = TipoRegistro.RNP;
    }

    public void tipoRegistroRegistro() {
        this.tipoRegistro = TipoRegistro.REGISTRO;
    }

    public void statusRnpAtivo() {
        this.statusRnp = StatusRnp.ATIVO;
    }

    public void statusRnpInativo() {
        this.statusRnp = StatusRnp.INATIVO;
    }

}


enum TipoRegistro { // verficar os tipos
    REGISTRO,
    RNP
}

enum StatusRnp {
    ATIVO,
    INATIVO
}