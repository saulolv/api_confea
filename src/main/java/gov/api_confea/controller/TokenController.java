package gov.api_confea.controller;

import gov.api_confea.dtos.LoginRequestDto;
import gov.api_confea.dtos.LoginResponse;
import gov.api_confea.model.Usuario;
import gov.api_confea.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class TokenController extends BaseController {

    private final AuthService authService;

    public TokenController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponse response = authService.authenticate(loginRequestDto);

        if (response == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/usuario_logado")
    public ResponseEntity<Usuario> pegarUsuarioLogado(@RequestHeader("Authorization") String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().build();
        }

        String jwtToken = token.substring(7); // Remove "Bearer " prefix
        Usuario usuario = authService.getUsuario(jwtToken);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuario);
    }
}
