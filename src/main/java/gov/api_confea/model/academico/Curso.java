package gov.api_confea.model.academico;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "tb_cursos")
@Data
public class Curso {

    @Id
    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;

    @Enumerated
    @Column(nullable = false)
    private Nivel nivel;

    @Column(nullable = false)
    private String coordenador;

    @Column(nullable = false)
    private String modalidade;

    @Column(nullable = false)
    private String turno;

    @ManyToOne
    @JoinColumn(name = "id_universidade", referencedColumnName = "id")
    private Universidade universidade;

    @OneToOne
    @JoinColumn(name = "codigo_titulo", referencedColumnName = "codigo")
    private Titulo titulo;

    @OneToMany
    private Set<Grade> grades;

    public Titulo getTitulo() {
        return this.titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
        titulo.addCurso(this);
    }

    public void removeTitulo() {
        if (titulo != null) {
            titulo.addCurso(null);
            this.titulo = null;
        }
    }
}

enum Nivel {
    GRADUACAO,
    POS_GRADUACAO,
    MESTRADO,
    DOUTORADO,
    POS_DOUTORADO
}