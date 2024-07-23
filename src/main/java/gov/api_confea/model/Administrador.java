package gov.api_confea.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "tb_administradores")
@Data
public class Administrador extends Usuario {

    @Enumerated
    private Cargo cargo;
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