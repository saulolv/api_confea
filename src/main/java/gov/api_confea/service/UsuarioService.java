package gov.api_confea.service;

import gov.api_confea.model.Usuario;

public interface UsuarioService {
    Usuario buscarPorEmailouCpf(String email, String cpf);
}
