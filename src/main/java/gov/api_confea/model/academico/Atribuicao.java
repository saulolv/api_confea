package gov.api_confea.model.academico;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "tb_atribuicoes")
@Data
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
}
