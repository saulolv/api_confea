package gov.api_confea.repository;

import gov.api_confea.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, UUID> {
}
