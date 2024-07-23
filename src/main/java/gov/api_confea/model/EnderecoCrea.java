package gov.api_confea.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_enderecos_crea")
@Data
public class EnderecoCrea extends Endereco {

    @Column(nullable = false, length = 30)
    private LocalDateTime inicioExpediente;

    @Column(nullable = false, length = 30)
    private LocalDateTime fimExpediente;

    @ManyToOne
    @JoinColumn(name = "codigo_crea", referencedColumnName = "codigo_crea")
    private Crea crea;
}
