package gov.api_confea.model.academico;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_grupos")
public class Grupo {

    @Id
    @Column(nullable = false, unique = true)
    private Integer codigo;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "grupo")
    private Set<Modalidade> modalidades;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Modalidade> getModalidades() {
        return modalidades;
    }

    public void setModalidades(Set<Modalidade> modalidades) {
        this.modalidades = modalidades;
    }
}
