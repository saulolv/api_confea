package gov.api_confea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "tb_enderecos_usuarios")
public class EnderecoUsuario extends Endereco {
}
