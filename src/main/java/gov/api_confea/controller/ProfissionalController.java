package gov.api_confea.controller;

import gov.api_confea.dtos.ProfissionalFiltroDto;
import gov.api_confea.model.Profissional;
import gov.api_confea.service.ProfissionalService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    public ProfissionalController(ProfissionalService profissionalService) {
        this.profissionalService = profissionalService;
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<Profissional>> listarProfissionais(ProfissionalFiltroDto profissionalFiltroDto) {
        Page<Profissional> profissionais = profissionalService.listarProfissionais(profissionalFiltroDto);

        return ResponseEntity.ok(profissionais);
    }
}
