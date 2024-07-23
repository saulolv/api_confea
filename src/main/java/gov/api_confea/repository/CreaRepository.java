package gov.api_confea.repository;

import gov.api_confea.model.Crea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreaRepository extends JpaRepository<Crea, String> {
}
