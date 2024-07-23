package gov.api_confea.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "tb_creas")
@Data
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
    private Set<Usuario> usuarios;

    protected Crea() {
    }

    public Crea(String codigoCrea, String nome, String cnpj, String email, String assinaturaPresidente, Set<EnderecoCrea> enderecos) {
        if(enderecos == null || enderecos.isEmpty())
            throw new IllegalArgumentException("Endereços não podem ser nulos ou vazios");
        this.codigoCrea = codigoCrea;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.assinaturaPresidente = assinaturaPresidente;
        this.enderecos = enderecos;
    }


}
