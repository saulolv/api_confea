package gov.api_confea.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_enderecos_usuarios")
public class EnderecoUsuario extends Endereco {

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @JsonBackReference
    private Usuario usuario;

    public EnderecoUsuario() {
    }

    public EnderecoUsuario(String nome, String cep, String uf, String cidade, String bairro, String logradouro, String tipoLogradouro, String numero) {
        super(nome, cep, uf, cidade, bairro, logradouro, tipoLogradouro, numero);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
