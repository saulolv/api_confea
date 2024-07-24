package gov.api_confea.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name="tb_telefones")
public class Telefone {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 5)
    private String ddd;

    @Column(nullable = false, length = 20, unique = true)
    private String numero;

    @Enumerated
    @Column(nullable = false, length = 20, name = "tipo_telefone")
    private TipoTelefone tipo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_crea")
    @JsonBackReference
    private Crea crea;

    public UUID getId() {
        return id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoTelefone getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefone tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Crea getCrea() {
        return crea;
    }

    public void setCrea(Crea crea) {
        this.crea = crea;
    }

    public void setTipoTelefoneResidencial() {
        this.tipo = TipoTelefone.RESIDENCIAL;
    }

    public void setTipoTelefoneComercial() {
        this.tipo = TipoTelefone.COMERCIAL;
    }

    public void setTipoTelefoneCelular() {
        this.tipo = TipoTelefone.CELULAR;
    }

    public void setTipoTelefoneRecado() {
        this.tipo = TipoTelefone.RECADO;
    }
}

enum TipoTelefone {
    RESIDENCIAL,
    COMERCIAL,
    CELULAR,
    RECADO
}