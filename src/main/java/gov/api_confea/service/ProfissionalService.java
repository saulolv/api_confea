package gov.api_confea.service;


import gov.api_confea.dtos.ProfissionalFiltroDto;
import gov.api_confea.model.Profissional;
import org.springframework.data.domain.Page;

public interface ProfissionalService {

    Page<Profissional> listarProfissionais(ProfissionalFiltroDto profissionalFiltroDto);
}
