package gov.api_confea.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_titulos_eleitorais")
@Data
public class TituloEleitoral {

    @Id
    @Column(unique = true, nullable = false)
    private Long codigo;

    private String zona;
    private String secao;
    private String municipio;
    private String uf;

    @OneToOne(mappedBy = "tituloEleitoral")
    private Usuario usuario;
}
