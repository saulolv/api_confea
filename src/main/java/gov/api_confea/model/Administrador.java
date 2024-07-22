package gov.api_confea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_administradores")
public class Administrador extends Usuario {

        private Cargo cargo;

        // Getters and Setters

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