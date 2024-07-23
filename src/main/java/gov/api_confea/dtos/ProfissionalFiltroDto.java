package gov.api_confea.dtos;

public class ProfissionalFiltroDto {
    private String nome;
    private String rnp;
    private String ufNaturalidade;
    private String cidadeNaturalidade;

    private int pagina = 0;
    private int tamanho = 10;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRnp() {
        return rnp;
    }

    public void setRnp(String rnp) {
        this.rnp = rnp;
    }

    public String getUfNaturalidade() {
        return ufNaturalidade;
    }

    public void setUfNaturalidade(String ufNaturalidade) {
        this.ufNaturalidade = ufNaturalidade;
    }

    public String getCidadeNaturalidade() {
        return cidadeNaturalidade;
    }

    public void setCidadeNaturalidade(String cidadeNaturalidade) {
        this.cidadeNaturalidade = cidadeNaturalidade;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
