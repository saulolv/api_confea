package gov.api_confea.model.academico;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_modalidades")
public class Modalidade {

    @Id
    @Column(nullable = false, unique = true)
    private int codigo;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "modalidade")
    private Set<Titulo> titulos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "codigo_grupo", referencedColumnName = "codigo")
    private Grupo grupo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Titulo> getTitulos() {
        return titulos;
    }

    public void setTitulos(Set<Titulo> titulos) {
        this.titulos = titulos;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

}
