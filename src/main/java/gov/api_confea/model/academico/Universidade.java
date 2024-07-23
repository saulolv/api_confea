package gov.api_confea.model.academico;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_universidades")
@Data
public class Universidade {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String denominacao;

    @Column(nullable = false)
    private String sigla;

    @Column(name = "municipio_sede", nullable = false)
    private String municipioSede;

    @Column(nullable = false)
    private String regiao;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String telefone;
    private String site;

    @OneToMany(mappedBy = "universidade", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Curso> cursos;
}
