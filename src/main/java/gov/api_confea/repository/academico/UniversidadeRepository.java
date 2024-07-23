package gov.api_confea.repository.academico;

import gov.api_confea.model.academico.Universidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UniversidadeRepository extends JpaRepository<Universidade, UUID> {
}
