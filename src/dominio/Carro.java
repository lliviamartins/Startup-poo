package dominio;

public class Carro extends Veiculo {

    public Carro(Placa placa, String modelo, String cor) {
        super(placa, modelo, cor);
    }

    @Override
    public String getTipo() {
        return "Carro";
    }
}



