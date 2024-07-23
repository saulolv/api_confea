package gov.api_confea.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_rgs")
@Data
public class Rg {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 20)
    private String numero;

    @Column(nullable = false, length = 40)
    private String orgaoExpedidor;

    @Column(nullable = false, length = 20, name = "data_expedicao")
    private LocalDate dataExpedicao;

    @Column(nullable = false, name="data_criacao")
    private final LocalDateTime dataCriacao = LocalDateTime.now();

    @OneToOne(mappedBy = "rg")
    private Usuario usuario;
}