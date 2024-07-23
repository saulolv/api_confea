package gov.api_confea.service.impl;

import gov.api_confea.dtos.ProfissionalFiltroDto;
import gov.api_confea.model.Profissional;
import gov.api_confea.repository.ProfissionalRepository;
import gov.api_confea.service.ProfissionalService;
import gov.api_confea.specification.ProfissionalSpecification;
import org.hibernate.annotations.DialectOverride;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProfissionalServiceImpl implements ProfissionalService {

    private final ProfissionalRepository profissionalRepository;

    public ProfissionalServiceImpl(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }

    public Page<Profissional> listarProfissionais(ProfissionalFiltroDto profissionalFiltroDto) {
        Pageable pageable = PageRequest.of(profissionalFiltroDto.getPagina(), profissionalFiltroDto.getTamanho());

       return profissionalRepository.findAll(ProfissionalSpecification.filtrar(profissionalFiltroDto), pageable);
    }
}
