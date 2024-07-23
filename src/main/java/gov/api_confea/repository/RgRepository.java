package gov.api_confea.repository;

import gov.api_confea.model.Rg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RgRepository extends JpaRepository<Rg, UUID> {
}
