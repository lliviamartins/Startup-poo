package dominio;

public abstract class Veiculo {

    private final Placa placa;
    private final String modelo;
    private final String cor;

    public Veiculo(Placa placa, String modelo, String cor) {
        if (placa == null) {
            throw new IllegalArgumentException("A placa é obrigatória.");
        }

        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("O modelo é obrigatório.");
        }

        if (cor == null || cor.isBlank()) {
            throw new IllegalArgumentException("A cor é obrigatória.");
        }

        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
    }

    public Placa getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public abstract String getTipo();

}