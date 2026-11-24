package dominio;

public class Vaga implements Identificavel {

    private int id;
    private TipoVaga tipo;
    private boolean ocupada;

    public Vaga(int id, TipoVaga tipo) {
        this.id = id;
        this.tipo = tipo;
        this.ocupada = false;
    }

    @Override
    public int getId() {
        return id;
    }

    public TipoVaga getTipo() {
        return tipo;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void ocupar() {
        this.ocupada = true;
    }

    public void liberar() {
        this.ocupada = false;
    }
}