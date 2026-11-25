package dominio;

// Moto: só ocupa vaga de moto.
public class Moto extends Veiculo {

    public Moto(Placa placa) {
        super(placa);
    }

    @Override
    public boolean aceitaVaga(TipoVaga tipo) {
        return tipo == TipoVaga.MOTO;
    }

    @Override
    public TipoVaga tipoPreferencial() {
        return TipoVaga.MOTO;
    }

    @Override
    public String nomeDoTipo() {
        return "Moto";
    }
}