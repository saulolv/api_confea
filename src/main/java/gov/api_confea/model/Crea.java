package gov.api_confea.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_creas")
public class Crea {

    @Id
    @Column(nullable = false, length = 10)
    private String codigoCrea;

    @Column(nullable = false, length = 40, unique = true)
    private String nome;


}
