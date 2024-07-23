package gov.api_confea.model.academico;

import gov.api_confea.model.Profissional;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_grades")
public class Grade {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, name = "periodo_inicio")
    private String periodoInicio;

    @Column(nullable = false, name = "periodo_fim")
    private String periodoFim;

    @ManyToOne
    @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo")
    private Curso curso;

    @ManyToMany(mappedBy = "grades")
    private Set<Profissional> profissionais = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "atribuicoes_grades",
            joinColumns = @JoinColumn(name = "id_grade"),
            inverseJoinColumns = @JoinColumn(name = "codigo_atribuicao")
    )
    private Set<Atribuicao> atribuicoes = new HashSet<>();

    public Set<Profissional> getProfissionais() {
        return this.profissionais;
    }

    public Set<Atribuicao> getAtribuicoes() {
        return this.atribuicoes;
    }

    public void addProfissional(Profissional profissional) {
        this.profissionais.add(profissional);
        profissional.getGrades().add(this);
    }

    public void removeProfissional(Profissional profissional) {
        this.profissionais.remove(profissional);
        profissional.getGrades().remove(this);
    }

    public void addAtribuicao(Atribuicao atribuicao) {
        this.atribuicoes.add(atribuicao);
        atribuicao.getGrades().add(this);
    }

    public void removeAtribuicao(Atribuicao atribuicao) {
        this.atribuicoes.remove(atribuicao);
        atribuicao.getGrades().remove(this);
    }
}
