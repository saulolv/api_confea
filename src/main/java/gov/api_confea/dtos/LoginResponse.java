package gov.api_confea.dtos;

public record LoginResponse(String accessToken, Long expiresIn) {
}
