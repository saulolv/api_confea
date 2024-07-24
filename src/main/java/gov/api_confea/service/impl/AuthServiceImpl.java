// src/main/java/gov/api_confea/service/impl/AuthServiceImpl.java

package gov.api_confea.service.impl;

import gov.api_confea.dtos.LoginRequestDto;
import gov.api_confea.dtos.LoginResponse;
import gov.api_confea.model.Administrador;
import gov.api_confea.model.Usuario;
import gov.api_confea.service.AuthService;
import gov.api_confea.service.UsuarioService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    private final UsuarioService usuarioService;
    private final JwtEncoder jwtEncoder;
    private final JwtDecoder jwtDecoder;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthServiceImpl(UsuarioService usuarioService, JwtEncoder jwtEncoder, JwtDecoder jwtDecoder, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioService = usuarioService;
        this.jwtEncoder = jwtEncoder;
        this.jwtDecoder = jwtDecoder;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public LoginResponse authenticate(LoginRequestDto loginRequestDto) {
        Usuario usuario = usuarioService.buscarPorEmailouCpf(loginRequestDto.getLogin());

        if (usuario == null || !bCryptPasswordEncoder.matches(loginRequestDto.getSenha(), usuario.getSenha())) {
            throw new IllegalArgumentException("Credenciais inválidas");
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

    @Override
    public Usuario getUsuario(String token) {

        Jwt jwt = jwtDecoder.decode(token);
        UUID userId = UUID.fromString(jwt.getSubject());

        Usuario usuario = usuarioService.encontrarPorId(userId);

        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        return usuario;
    }
}
