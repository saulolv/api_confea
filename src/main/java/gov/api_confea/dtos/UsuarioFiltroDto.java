package gov.api_confea.dtos;

public class UsuarioFiltroDto {
    private String cpf;
    private String email;

    public UsuarioFiltroDto(String email, String cpf) {
        this.email = email;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
