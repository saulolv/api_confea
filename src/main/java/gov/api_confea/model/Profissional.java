package gov.api_confea.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import gov.api_confea.model.academico.Grade;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_profissionais")
public class Profissional extends Usuario {

    @Column(nullable = false, name="rnp", unique = true)
    private String rnp;

    @Column(nullable = false, length = 40, name="num_registro_crea")
    private String numRegistroCrea;

    @Enumerated
    @Column(nullable = false, name="tipo_numero_carteira")
    private TipoNumeroCarteira tipoNumeroCarteira;

    @Enumerated
    @Column(nullable = false, name="estado_civil")
    private EstadoCivil estadoCivil;

    @Column(nullable = false, name="nome_mae")
    private String nomeMae;

    @Enumerated
    @Column(name="tipo_sanguineo")
    private TipoSanguineo tipoSanguineo;

    @Enumerated
    @Column(name="fator_rh")
    private FatorRh fatorRh;

    @Column(name="doador_orgaos")
    private Boolean doadorOrgaos;

    private String website;

    @Column(name="nome_pai")
    private String nomePai;

    @OneToOne(mappedBy = "profissional", cascade = CascadeType.ALL)
    @JsonManagedReference
    private TituloEleitoral tituloEleitoral;

    @OneToOne(optional = true)
    @JoinColumn(name = "id_vinculo", referencedColumnName = "id")
    @JsonManagedReference
    private Vinculo vinculo;

    @OneToOne(mappedBy = "profissional", cascade = CascadeType.ALL)
    @JoinColumn(name = "codigo", referencedColumnName = "codigo")
    @JsonManagedReference
    private Carteira carteira;

    @ManyToMany
    @JoinTable(
        name = "profissionais_grades",
        joinColumns = @JoinColumn(name = "id_profissional"),
        inverseJoinColumns = @JoinColumn(name = "id_grade")
    )
    private Set<Grade> grades = new HashSet<>();

    @OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL)
    private Set<Art> arts = new HashSet<>();

    public Set<Grade> getGrades() {
        return this.grades;
    }

    public Profissional() {
    }

    public Profissional(String nome, String email, String cpf, String senha, Sexo sexo, LocalDate dataNascimento, PNE pne, String nacionalidade, String cidadeNaturalidade, String ufNaturalidade, String paisNascimento, Rg rg, Crea crea, Set<Telefone> telefones, String rnp, String numRegistroCrea, TipoNumeroCarteira tipoNumeroCarteira, EstadoCivil estadoCivil, String nomeMae, Carteira carteira) {
        super(nome, email, cpf, senha, sexo, dataNascimento, pne, nacionalidade, cidadeNaturalidade, ufNaturalidade, paisNascimento, rg, crea, telefones);
        this.rnp = rnp;
        this.numRegistroCrea = numRegistroCrea;
        this.tipoNumeroCarteira = tipoNumeroCarteira;
        this.estadoCivil = estadoCivil;
        this.nomeMae = nomeMae;
        this.carteira = carteira;
    }

    public String getRnp() {
        return rnp;
    }

    public void setRnp(String rnp) {
        this.rnp = rnp;
    }

    public String getNumRegistroCrea() {
        return numRegistroCrea;
    }

    public void setNumRegistroCrea(String numRegistroCrea) {
        this.numRegistroCrea = numRegistroCrea;
    }

    public TipoNumeroCarteira getTipoNumeroCarteira() {
        return tipoNumeroCarteira;
    }

    public void setTipoNumeroCarteira(TipoNumeroCarteira tipoNumeroCarteira) {
        this.tipoNumeroCarteira = tipoNumeroCarteira;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public FatorRh getFatorRh() {
        return fatorRh;
    }

    public void setFatorRh(FatorRh fatorRh) {
        this.fatorRh = fatorRh;
    }

    public Boolean getDoadorOrgaos() {
        return doadorOrgaos;
    }

    public void setDoadorOrgaos(Boolean doadorOrgaos) {
        this.doadorOrgaos = doadorOrgaos;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    @Override
    public TituloEleitoral getTituloEleitoral() {
        return tituloEleitoral;
    }

    @Override
    public void setTituloEleitoral(TituloEleitoral tituloEleitoral) {
        this.tituloEleitoral = tituloEleitoral;
    }

    public Set<Art> getArts() {
        return arts;
    }

    public void setArts(Set<Art> arts) {
        this.arts = arts;
    }

    public Vinculo getVinculo() {
        return vinculo;
    }

    public void setVinculo(Vinculo vinculo) {
        this.vinculo = vinculo;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    public void setTipoNumeroCarteiraCrea() {
        this.tipoNumeroCarteira = TipoNumeroCarteira.CREA;
    }

    public void setTipoNumeroCarteiraConfea() {
        this.tipoNumeroCarteira = TipoNumeroCarteira.CONFEA;
    }

    public void setEstadoCivilSolteiro() {
        this.estadoCivil = EstadoCivil.SOLTEIRO;
    }

    public void setEstadoCivilCasado() {
        this.estadoCivil = EstadoCivil.CASADO;
    }

    public void setEstadoCivilDivorciado() {
        this.estadoCivil = EstadoCivil.DIVORCIADO;
    }

    public void setEstadoCivilViuvo() {
        this.estadoCivil = EstadoCivil.VIUVO;
    }

    public void setTipoSanguineoA() {
        this.tipoSanguineo = TipoSanguineo.A;
    }

    public void setTipoSanguineoB() {
        this.tipoSanguineo = TipoSanguineo.B;
    }

    public void setTipoSanguineoAB() {
        this.tipoSanguineo = TipoSanguineo.AB;
    }

    public void setTipoSanguineoO() {
        this.tipoSanguineo = TipoSanguineo.O;
    }

    public void setFatorRhPositivo() {
        this.fatorRh = FatorRh.POSITIVO;
    }

    public void setFatorRhNegativo() {
        this.fatorRh = FatorRh.NEGATIVO;
    }

    public void addGrade(Grade grade) {
        this.grades.add(grade);
        grade.getProfissionais().add(this);
    }

    public void removeGrade(Grade grade) {
        this.grades.remove(grade);
        grade.getProfissionais().remove(this);
    }

}

enum TipoNumeroCarteira {
    CREA,
    CONFEA
}

enum EstadoCivil {
    SOLTEIRO,
    CASADO,
    DIVORCIADO,
    VIUVO
}

enum TipoSanguineo {
    A,
    B,
    AB,
    O
}

enum FatorRh {
    POSITIVO,
    NEGATIVO
}
