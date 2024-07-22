package gov.api_confea.model;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@MappedSuperclass
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String cpf;



    @OneToOne
    @JoinColumn(name = "codigo_crea")
    private Crea crea;
}
