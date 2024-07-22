package gov.api_confea.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "tb_usuarios")
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
    @JoinColumn(name = "codigo_crea")
    private Crea crea;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    private Set<Telefone> telefones;

    @Column(nullable = false, name="data_criacao")
    private final LocalDateTime dataCriacao = LocalDateTime.now();
}

enum Sexo {
    MASCULINO,
    FEMININO
}

enum PNE { // Precisa ser configurado adequadamente
    SIM,
    NAO
}
