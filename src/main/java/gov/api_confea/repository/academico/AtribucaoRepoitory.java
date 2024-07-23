package gov.api_confea.repository.academico;

import gov.api_confea.model.academico.Atribuicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtribucaoRepoitory extends JpaRepository<Atribuicao, Integer>{
}
