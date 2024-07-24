package gov.api_confea.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "tb_administradores")
public class Administrador extends Usuario {

    @Enumerated
    private Cargo cargo;

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setCargoPresidente() {
        this.cargo = Cargo.PRESIDENTE;
    }

    public void setCargoVicePresidente() {
        this.cargo = Cargo.VICE_PRESIDENTE;
    }

    public void setCargoSecretario() {
        this.cargo = Cargo.SECRETARIO;
    }

    public void setCargoTesoureiro() {
        this.cargo = Cargo.TESOUREIRO;
    }

    public void setCargoConselheiro() {
        this.cargo = Cargo.CONSELHEIRO;
    }

    public void setCargoDiretor() {
        this.cargo = Cargo.DIRETOR;
    }

    public void setCargoGerente() {
        this.cargo = Cargo.GERENTE;
    }

    public void setCargoSupervisor() {
        this.cargo = Cargo.SUPERVISOR;
    }

    public void setCargoCoordenador() {
        this.cargo = Cargo.COORDENADOR;
    }
}

enum Cargo {
    PRESIDENTE,
    VICE_PRESIDENTE,
    SECRETARIO,
    TESOUREIRO,
    CONSELHEIRO,
    DIRETOR,
    GERENTE,
    SUPERVISOR,
    COORDENADOR
}