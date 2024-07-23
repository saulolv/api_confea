package gov.api_confea.model;

import gov.api_confea.model.academico.Grade;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_profissionais")
@Data
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

    @Enumerated
    @Column(name="tipo_sanguineo")
    private TipoSanguineo tipoSanguineo;

    @Enumerated
    @Column(name="fator_rh")
    private FatorRh fatorRh;

    @Column(name="doador_orgaos")
    private Boolean doadorOrgaos;

    private String website;

    @Column(nullable = false, name="nome_mae")
    private String nomeMae;

    @Column(name="nome_pai")
    private String nomePai;

    @OneToOne(optional = true)
    @JoinColumn(name = "codigo_titulo_eleitoral", referencedColumnName = "codigo")
    private TituloEleitoral tituloEleitoral;

    @OneToOne(optional = true)
    @JoinColumn(name = "id_vinculo", referencedColumnName = "id")
    private Vinculo vinculo;

    @OneToOne(mappedBy = "profissional", cascade = CascadeType.ALL)
    @JoinColumn(name = "codigo", referencedColumnName = "codigo")
    private Carteira carteira;

    @ManyToMany
    @JoinTable(
        name = "profissionais_grades",
        joinColumns = @JoinColumn(name = "id_profissional"),
        inverseJoinColumns = @JoinColumn(name = "id_grade")
    )
    private Set<Grade> grades = new HashSet<>();

    public Set<Grade> getGrades() {
        return this.grades;
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

// Revisar enums

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
