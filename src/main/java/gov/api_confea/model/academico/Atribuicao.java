package gov.api_confea.model.academico;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "tb_atribuicoes")
public class Atribuicao {

    @Id
    @Column(nullable = false, unique = true)
    private Integer codigo;

    private String atribuicao;
    private String descricao;

    @ManyToMany(mappedBy = "atribuicoes")
    private Set<Grade> grades;

    public Set<Grade> getGrades() {
        return this.grades;
    }

    public void addGrade(Grade grade) {
        this.grades.add(grade);
        grade.getAtribuicoes().add(this);
    }

    public void removeGrade(Grade grade) {
        this.grades.remove(grade);
        grade.getAtribuicoes().remove(this);
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getAtribuicao() {
        return atribuicao;
    }

    public void setAtribuicao(String atribuicao) {
        this.atribuicao = atribuicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }
}
