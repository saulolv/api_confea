package gov.api_confea.dtos;

public class UsuarioFiltroDto {
    private String login;

    public UsuarioFiltroDto(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
