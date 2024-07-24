package gov.api_confea.repository.pagamento;

import gov.api_confea.model.pagamento.Anuidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnuidadeRepository extends JpaRepository<Anuidade, UUID> {
}
