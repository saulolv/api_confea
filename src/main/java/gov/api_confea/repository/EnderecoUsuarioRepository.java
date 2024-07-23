package gov.api_confea.repository;

import gov.api_confea.model.EnderecoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoUsuarioRepository extends JpaRepository<EnderecoUsuario, UUID>{
}
