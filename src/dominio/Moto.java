

public class Moto extends Veiculo {

    public Moto(Placa placa, String modelo, String cor) {
        super(placa, modelo, cor);
    }

    @Override
    public String getTipo() {
        return "Moto";
    }
}


