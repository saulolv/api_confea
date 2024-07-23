package gov.api_confea.repository;

import gov.api_confea.model.EnderecoCrea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoCreaRepository extends JpaRepository<EnderecoCrea, UUID> {
}
