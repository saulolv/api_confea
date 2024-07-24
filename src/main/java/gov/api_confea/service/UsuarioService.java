package gov.api_confea.service;

import gov.api_confea.model.Usuario;

import java.util.UUID;

public interface UsuarioService {
    Usuario encontrarPorId(UUID id);
    Usuario buscarPorEmailouCpf(String login);
}
