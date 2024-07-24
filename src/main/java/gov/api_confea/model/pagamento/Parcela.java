package gov.api_confea.model.pagamento;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_parcelas")
public class Parcela {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private Integer valor;

    @Column(nullable = false, name = "numero_parcelamento")
    private Integer numeroParcelamento;

    @Column(nullable = false, name = "valor_parcela")
    private LocalDateTime dataPagamento;

    @Column(nullable = false, name = "data_pagamento")
    private String tipoPagamento;

    @ManyToOne
    private Anuidade anuidade;

    public Parcela() {
    }

    public Parcela(Integer valor, Integer numeroParcelamento, LocalDateTime dataPagamento, String tipoPagamento) {
        this.valor = valor;
        this.numeroParcelamento = numeroParcelamento;
        this.dataPagamento = dataPagamento;
        this.tipoPagamento = tipoPagamento;
    }

    public UUID getId() {
        return id;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getNumeroParcelamento() {
        return numeroParcelamento;
    }

    public void setNumeroParcelamento(Integer numeroParcelamento) {
        this.numeroParcelamento = numeroParcelamento;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Anuidade getAnuidade() {
        return anuidade;
    }

    public void setAnuidade(Anuidade anuidade) {
        this.anuidade = anuidade;
    }
}
