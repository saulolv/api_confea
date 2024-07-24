package gov.api_confea.model;

import gov.api_confea.model.pagamento.Anuidade;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_vinculos")
@Data
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
    private List<Anuidade> anuidade = new ArrayList<>();
}

enum TipoRegistro { // verficar os tipos
    REGISTRO,
    RNP
}

enum StatusRnp {
    ATIVO,
    INATIVO
}