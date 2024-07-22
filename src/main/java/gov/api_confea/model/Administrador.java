package gov.api_confea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_administradores")
public class Administrador extends Usuario {
}
