package gov.api_confea.model.academico;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_modalidades")
@Data
public class Modalidade {

    @Id
    @Column(nullable = false, unique = true)
    private Integer codigo;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "modalidade")
    private Set<Titulo> titulos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "codigo_grupo", referencedColumnName = "codigo")
    private Grupo grupo;
}
