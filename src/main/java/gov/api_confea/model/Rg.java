package gov.api_confea.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_rgs")
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
    @JsonBackReference
    private Usuario usuario;

    public UUID getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }

    public LocalDate getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(LocalDate dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}