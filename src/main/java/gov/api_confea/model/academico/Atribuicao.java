package gov.api_confea.model.academico;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_atribuicoes")
public class Atribuicao {

    @Id
    @Column(nullable = false, unique = true)
    private int codigo;

    private String atribuicao;
    private String descricao;

    @ManyToMany(mappedBy = "atribuicoes")
    private Set<Grade> grades;


    // Getters and Setters



    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    public void addGrade(Grade grade) {
        this.grades.add(grade);
        grade.getAtribuicoes().add(this);
    }

    public void removeGrade(Grade grade) {
        this.grades.remove(grade);
        grade.getAtribuicoes().remove(this);
    }
}
