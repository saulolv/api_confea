package gov.api_confea.model.academico;

import gov.api_confea.model.Carteira;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_titulos")
@Data
public class Titulo {

    @Id
    @Column(nullable = false, unique = true)
    private String codigo;

    private String nomeMasculino;
    private String nomeFeminino;
    private String nomeAbreviado;
    private Boolean ativo;

    @OneToOne(mappedBy = "titulo")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "codigo_modalidade", referencedColumnName = "codigo")
    private Modalidade modalidade;

    @ManyToMany(mappedBy = "titulos")
    private Set<Carteira> carteiras = new HashSet<>();

    public Set<Carteira> getCarteiras() {
        return this.carteiras;
    }

    public void addCurso(Curso curso) {
        this.curso = curso;
        if (curso != null && curso.getTitulo() != this) {
            curso.setTitulo(this);
        }
    }

    public void removeCurso() {
        if (curso != null) {
            Curso tempCurso = this.curso;
            this.curso = null;
            tempCurso.removeTitulo();
        }
    }

    public void addCarteira(Carteira carteira) {
        this.carteiras.add(carteira);
        carteira.getTitulos().add(this);
    }

    public void removeCarteira(Carteira carteira) {
        this.carteiras.remove(carteira);
        carteira.getTitulos().remove(this);
    }
}
