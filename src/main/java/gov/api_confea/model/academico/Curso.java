package gov.api_confea.model.academico;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_cursos")
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

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
        titulo.setCurso(this);
    }

    public void removeTitulo() {
        if (titulo != null) {
            titulo.setCurso(null);
            this.titulo = null;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Universidade getUniversidade() {
        return universidade;
    }

    public void setUniversidade(Universidade universidade) {
        this.universidade = universidade;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public Set<Grade> getGrades() {
        return grades;
    }



    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }
}

enum Nivel {
    GRADUACAO,
    POS_GRADUACAO,
    MESTRADO,
    DOUTORADO,
    POS_DOUTORADO
}