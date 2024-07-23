package gov.api_confea.repository;

import gov.api_confea.model.Vinculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VinculoRepository extends JpaRepository<Vinculo, UUID> {
}
