package gov.api_confea.service.impl;

import gov.api_confea.dtos.LoginRequestDto;
import gov.api_confea.dtos.LoginResponse;
import gov.api_confea.model.Administrador;
import gov.api_confea.model.Usuario;
import gov.api_confea.service.AuthService;
import gov.api_confea.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthServiceImpl implements AuthService {

    private UsuarioService usuarioService;
    private JwtEncoder jwtEncoder;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthServiceImpl(UsuarioService usuarioService, JwtEncoder jwtEncoder, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioService = usuarioService;
        this.jwtEncoder = jwtEncoder;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public LoginResponse authenticate(LoginRequestDto loginRequestDto) {
        Usuario usuario = usuarioService.buscarPorEmailouCpf(loginRequestDto.getEmail(), loginRequestDto.getCpf());

        if (usuario == null || !bCryptPasswordEncoder.matches(loginRequestDto.getSenha(), usuario.getSenha())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        var now = Instant.now();
        var expiresIn = 300L;

        JwtClaimsSet.Builder claimsBuilder = JwtClaimsSet.builder()
                .issuer("https://api-confea.gov.br")
                .subject(usuario.getId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn));

        if (usuario instanceof Administrador) {
            claimsBuilder.claim("role", "ADMIN");
        } else {
            claimsBuilder.claim("role", "USER");
        }

        var claims = claimsBuilder.build();
        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponse(jwtValue, expiresIn);
    }

}
