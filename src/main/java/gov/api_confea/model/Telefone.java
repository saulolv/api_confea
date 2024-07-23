package gov.api_confea.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="tb_telefones")
public class Telefone {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 5)
    private String ddd;

    @Column(nullable = false, length = 20, unique = true)
    private String numero;

    @Enumerated
    @Column(nullable = false, length = 20, name = "tipo_telefone")
    private TipoTelefone tipo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_crea")
    private Crea crea;
}

enum TipoTelefone {
    RESIDENCIAL,
    COMERCIAL,
    CELULAR,
    RECADO
}