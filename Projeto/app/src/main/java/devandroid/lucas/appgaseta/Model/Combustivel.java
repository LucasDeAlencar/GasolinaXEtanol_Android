package devandroid.lucas.appgaseta.Model;

public class Combustivel {

    private int id;
    private String nomeDoCombustível;
    private double precoDoCombustivel;
    private String recomendacao;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDoCombustível() {
        return nomeDoCombustível;
    }

    public void setNomeDoCombustível(String nomeDoCombustível) {
        this.nomeDoCombustível = nomeDoCombustível;
    }

    public double getPrecoDoCombustivel() {
        return precoDoCombustivel;
    }

    public void setPrecoDoCombustivel(double precoDoCombustivel) {
        this.precoDoCombustivel = precoDoCombustivel;
    }

    public String getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }
}
