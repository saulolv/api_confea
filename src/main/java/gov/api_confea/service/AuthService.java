package gov.api_confea.service;

import gov.api_confea.dtos.LoginRequestDto;
import gov.api_confea.dtos.LoginResponse;
import gov.api_confea.model.Usuario;

public interface AuthService {
    LoginResponse authenticate(LoginRequestDto loginRequestDto);

    Usuario getUsuario(String token);
}
