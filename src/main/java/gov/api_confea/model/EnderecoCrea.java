package gov.api_confea.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public EnderecoCrea() {
    }

    public EnderecoCrea(String nome, String cep, String uf, String cidade, String bairro, String logradouro, String numeroLogradouro, String tipoLogradouro, LocalDateTime inicioExpediente, LocalDateTime fimExpediente) {
        super(nome, cep, uf, cidade, bairro, logradouro, numeroLogradouro, tipoLogradouro);
        this.inicioExpediente = inicioExpediente;
        this.fimExpediente = fimExpediente;
    }



    public LocalDateTime getInicioExpediente() {
        return inicioExpediente;
    }

    public void setInicioExpediente(LocalDateTime inicioExpediente) {
        this.inicioExpediente = inicioExpediente;
    }

    public LocalDateTime getFimExpediente() {
        return fimExpediente;
    }

    public void setFimExpediente(LocalDateTime fimExpediente) {
        this.fimExpediente = fimExpediente;
    }

    public Crea getCrea() {
        return crea;
    }

    public void setCrea(Crea crea) {
        this.crea = crea;
    }
}
