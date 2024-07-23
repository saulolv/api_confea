package gov.api_confea.repository;

import gov.api_confea.model.TituloEleitoral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TituloEleitoralRepository extends JpaRepository<TituloEleitoral, Long> {
}
