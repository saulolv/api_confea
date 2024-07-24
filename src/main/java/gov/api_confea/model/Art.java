package gov.api_confea.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "art")
public class Art {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_art")
    private Long numeroArt;

    @Column(name = "data_art")
    private LocalDate dataArt;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status")
    private String status;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_termino")
    private LocalDate dataTermino;

    @ManyToOne
    @JoinColumn(name = "id_profissional")
    private Profissional profissional;


    @ManyToOne
    @JoinColumn(name = "codigo_crea")
    private Crea crea;

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Long getNumeroArt() {
        return numeroArt;
    }

    public LocalDate getDataArt() {
        return dataArt;
    }

    public void setDataArt(LocalDate dataArt) {
        this.dataArt = dataArt;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Crea getCrea() {
        return crea;
    }

    public void setCrea(Crea crea) {
        this.crea = crea;
    }
}
