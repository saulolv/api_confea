package gov.api_confea.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_enderecos_crea")
public class EnderecoCrea extends Endereco {

    @Column(nullable = false, length = 30)
    private LocalDateTime inicioExpediente;

    @Column(nullable = false, length = 30)
    private LocalDateTime fimExpediente;

    @ManyToOne
    @JoinColumn(name = "codigo_crea", referencedColumnName = "codigo_crea")
    private Crea crea;


    // Getters and Setters

    public Crea getCrea() {
        return crea;
    }

    public void setCrea(Crea crea) {
        this.crea = crea;
    }

    public LocalDateTime getInicioExpediente() {
        return inicioExpediente;
    }

    public LocalDateTime getFimExpediente() {
        return fimExpediente;
    }

    public void setInicioExpediente(LocalDateTime inicioExpediente) {
        this.inicioExpediente = inicioExpediente;
    }

    public void setFimExpediente(LocalDateTime fimExpediente) {
        this.fimExpediente = fimExpediente;
    }
}
