package gov.api_confea.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_enderecos")
@Data
public abstract class Endereco {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 40)
    private String nome;

    @Column(nullable = false, length = 20)
    private String cep;

    @Column(nullable = false, length = 2)
    private String uf;

    @Column(nullable = false, length = 40)
    private String cidade;

    @Column(nullable = false, length = 40)
    private String bairro;

    @Column(nullable = false, length = 50)
    private String logradouro;

    @Column(nullable = false, length = 10)
    private String numeroLogradouro;

    @Column(nullable = false, length = 20)
    private String tipoLogradouro;

    @Column(length = 40)
    private String complemento;

    @Column(length = 20)
    private String fax;

    @Column(nullable = false, name="data_criacao")
    private final LocalDateTime dataCriacao = LocalDateTime.now();
}
