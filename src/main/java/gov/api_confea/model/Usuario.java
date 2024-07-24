package gov.api_confea.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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
    @JsonManagedReference
    private Rg rg;

    @ManyToOne
    @JoinColumn(name = "codigo_crea", referencedColumnName = "codigo_crea")
    @JsonBackReference
    private Crea crea;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
    @JsonManagedReference
    private Set<Telefone> telefones;

    @OneToOne
    @JoinColumn(name = "codigo_titulo_eleitoral", referencedColumnName = "codigo")
    @JsonManagedReference
    private TituloEleitoral tituloEleitoral;

    @Column(nullable = false, name="data_criacao")
    private final LocalDateTime dataCriacao = LocalDateTime.now();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<EnderecoUsuario> enderecos;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public PNE getPne() {
        return pne;
    }

    public void setPne(PNE pne) {
        this.pne = pne;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getCidadeNaturalidade() {
        return cidadeNaturalidade;
    }

    public void setCidadeNaturalidade(String cidadeNaturalidade) {
        this.cidadeNaturalidade = cidadeNaturalidade;
    }

    public String getUfNaturalidade() {
        return ufNaturalidade;
    }

    public void setUfNaturalidade(String ufNaturalidade) {
        this.ufNaturalidade = ufNaturalidade;
    }

    public String getPaisNascimento() {
        return paisNascimento;
    }

    public void setPaisNascimento(String paisNascimento) {
        this.paisNascimento = paisNascimento;
    }

    public Rg getRg() {
        return rg;
    }

    public void setRg(Rg rg) {
        this.rg = rg;
    }

    public Crea getCrea() {
        return crea;
    }

    public void setCrea(Crea crea) {
        this.crea = crea;
    }

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }

    public TituloEleitoral getTituloEleitoral() {
        return tituloEleitoral;
    }

    public void setTituloEleitoral(TituloEleitoral tituloEleitoral) {
        this.tituloEleitoral = tituloEleitoral;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Set<EnderecoUsuario> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<EnderecoUsuario> enderecos) {
        this.enderecos = enderecos;
    }

    public void setSexoMasculino() {
        this.sexo = Sexo.MASCULINO;
    }

    public void setSexoFeminino() {
        this.sexo = Sexo.FEMININO;
    }

    public void setSexoOutro() {
        this.sexo = Sexo.OUTRO;
    }

    public void setPNE() {
        this.pne = PNE.SIM;
    }

    public void setNaoPNE() {
        this.pne = PNE.NAO;
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
    FEMININO,
    OUTRO
}

enum PNE { // Precisa ser configurado adequadamente
    SIM,
    NAO
}
