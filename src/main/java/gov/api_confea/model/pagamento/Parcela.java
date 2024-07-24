package gov.api_confea.model.pagamento;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_parcelas")
@Getter
@Setter
@NoArgsConstructor
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

    public Parcela(Integer valor, Integer numeroParcelamento, LocalDateTime dataPagamento, String tipoPagamento) {
        this.valor = valor;
        this.numeroParcelamento = numeroParcelamento;
        this.dataPagamento = dataPagamento;
        this.tipoPagamento = tipoPagamento;
    }
}
