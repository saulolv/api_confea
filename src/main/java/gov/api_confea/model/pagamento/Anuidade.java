package gov.api_confea.model.pagamento;

import gov.api_confea.model.Vinculo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_anuidades")
@Getter @Setter @NoArgsConstructor
public class Anuidade {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private Integer valor;

    private String observacao;

    @Enumerated
    @Column(nullable = false)
    private StatusAnuidade status;

    @Column(nullable = false, name = "tipo_pagamento")
    private String tipoPagamento;

    @Column(nullable = false, name = "ano_pagamento")
    private String anoPagamento;

    @Column(nullable = false, name = "data_alteracao")
    private LocalDateTime dataAlteracao = LocalDateTime.now();

    @OneToMany
    @JoinColumn(name = "id_anuidade", referencedColumnName = "id")
    private List<Parcela> parcelas = new ArrayList<>();

    @ManyToOne
    private Vinculo vinculo;

    public Anuidade(Integer valor, StatusAnuidade status, String tipoPagamento, String anoPagamento) {
        this.valor = valor;
        this.status = status;
        this.tipoPagamento = tipoPagamento;
        this.anoPagamento = anoPagamento;
    }
}

enum StatusAnuidade {
    PENDENTE,
    PAGO,
    ISENTO,
    CANCELADO
}