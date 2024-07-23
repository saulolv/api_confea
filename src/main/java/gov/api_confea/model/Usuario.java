package gov.api_confea.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_usuarios")
@Data
public abstract class Usuario {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexo sexo;

    @Column(nullable = false, name="data_nascimento")
    private LocalDate dataNascimento;

    @Column(name="nome_social")
    private String nomeSocial;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PNE pne;

    @Column(nullable = false)
    private String nacionalidade;

    @Column(nullable = false, name="cidade_naturalidade")
    private String cidadeNaturalidade;

    @Column(nullable = false, name="uf_naturalidade")
    private String ufNaturalidade;

    @Column(nullable = false, name="pais_nascimento")
    private String paisNascimento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rg", referencedColumnName = "id")
    private Rg rg;

    @ManyToOne
    @JoinColumn(name = "codigo_crea", referencedColumnName = "codigo_crea")
    private Crea crea;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
    private Set<Telefone> telefones;

    @OneToOne
    @JoinColumn(name = "codigo_titulo_eleitoral", referencedColumnName = "codigo")
    private TituloEleitoral tituloEleitoral;

    @Column(nullable = false, name="data_criacao")
    private final LocalDateTime dataCriacao = LocalDateTime.now();


    protected Usuario() {
    }

    public Usuario(String nome, String email, String cpf, String senha, Sexo sexo, LocalDate dataNascimento, PNE pne, String nacionalidade, String cidadeNaturalidade, String ufNaturalidade, String paisNascimento, Rg rg, Crea crea, Set<Telefone> telefones) {
        if(crea == null)
            throw new IllegalArgumentException("CREA não pode ser nulo");

        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.pne = pne;
        this.nacionalidade = nacionalidade;
        this.cidadeNaturalidade = cidadeNaturalidade;
        this.ufNaturalidade = ufNaturalidade;
        this.paisNascimento = paisNascimento;
        this.rg = rg;
        this.crea = crea;
        this.telefones = telefones;
    }

    public UUID getId() {
        return this.id;
    }

    public String getSenha() {
        return this.senha;
    }

}

enum Sexo {
    MASCULINO,
    FEMININO
}

enum PNE { // Precisa ser configurado adequadamente
    SIM,
    NAO
}
