package gov.api_confea.model.academico;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "tb_grupos")
@Data
public class Grupo {

    @Id
    @Column(nullable = false, unique = true)
    private Integer codigo;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "grupo")
    private Set<Modalidade> modalidades;
}
