package gov.api_confea.model.academico;

import gov.api_confea.model.Carteira;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_titulos")
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


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeMasculino() {
        return nomeMasculino;
    }

    public void setNomeMasculino(String nomeMasculino) {
        this.nomeMasculino = nomeMasculino;
    }

    public String getNomeFeminino() {
        return nomeFeminino;
    }

    public void setNomeFeminino(String nomeFeminino) {
        this.nomeFeminino = nomeFeminino;
    }

    public String getNomeAbreviado() {
        return nomeAbreviado;
    }

    public void setNomeAbreviado(String nomeAbreviado) {
        this.nomeAbreviado = nomeAbreviado;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Curso getCurso() {
        return curso;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public Set<Carteira> getCarteiras() {
        return carteiras;
    }

    public void setCurso(Curso curso) {
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

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public void setCarteiras(Set<Carteira> carteiras) {
        this.carteiras = carteiras;
    }
}
