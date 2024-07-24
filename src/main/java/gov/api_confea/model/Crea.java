package gov.api_confea.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tb_creas")
public class Crea {

    @Id
    @Column(nullable = false, length = 10, name = "codigo_crea", unique = true)
    private String codigoCrea;

    @Column(nullable = false, length = 40, unique = true)
    private String nome;

    @Column(nullable = false, length = 30, unique = true)
    private String cnpj;

    @Column(nullable = false, length = 40)
    private String email;

    private String pageUrl;

    @Column(nullable = false, length = 40)
    private String assinaturaPresidente; // revisar tipo

    @OneToMany(mappedBy = "crea", cascade = CascadeType.ALL)
    private Set<EnderecoCrea> enderecos;

    @OneToMany(mappedBy = "crea", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Usuario> usuarios;

    public String getCodigoCrea() {
        return codigoCrea;
    }

    public void setCodigoCrea(String codigoCrea) {
        this.codigoCrea = codigoCrea;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void setAssinaturaPresidente(String assinaturaPresidente) {
        this.assinaturaPresidente = assinaturaPresidente;
    }

    public void setEnderecos(Set<EnderecoCrea> enderecos) {
        this.enderecos = enderecos;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public String getAssinaturaPresidente() {
        return assinaturaPresidente;
    }

    public Set<EnderecoCrea> getEnderecos() {
        return enderecos;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }
}
