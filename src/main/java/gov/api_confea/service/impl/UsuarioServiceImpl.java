package gov.api_confea.service.impl;

import gov.api_confea.dtos.UsuarioFiltroDto;
import gov.api_confea.model.Usuario;
import gov.api_confea.repository.UsuarioRepository;
import gov.api_confea.service.UsuarioService;
import gov.api_confea.specification.UsuarioSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario encontrarPorId(UUID id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario buscarPorEmailouCpf(String login) {
        UsuarioFiltroDto filtro = new UsuarioFiltroDto(login);
        Specification<Usuario> specification = UsuarioSpecification.filtrar(filtro);
        List<Usuario> usuarios = usuarioRepository.findAll(specification);
        return usuarios.isEmpty() ? null : usuarios.get(0);
    }


}
