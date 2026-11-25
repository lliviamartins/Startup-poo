package dominio;
// Carro comum: só ocupa vaga de carro.
public class Carro extends Veiculo {

    public Carro(Placa placa) {
        super(placa);
    }

    @Override
    public boolean aceitaVaga(TipoVaga tipo) {
        return tipo == TipoVaga.CARRO;
    }

    @Override
    public TipoVaga tipoPreferencial() {
        return TipoVaga.CARRO;
    }

    @Override
    public String nomeDoTipo() {
        return "Carro";
    }
}