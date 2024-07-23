package gov.api_confea.service;

import gov.api_confea.dtos.LoginRequestDto;
import gov.api_confea.dtos.LoginResponse;

public interface AuthService {
    LoginResponse authenticate(LoginRequestDto loginRequestDto);
}
