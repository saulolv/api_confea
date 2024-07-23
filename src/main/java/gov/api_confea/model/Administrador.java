package gov.api_confea.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_administradores")
public class Administrador extends Usuario {

    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated
    private Cargo cargo;

    // Getters and Setters


    @Override
    public UUID getId() {
        return id;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
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