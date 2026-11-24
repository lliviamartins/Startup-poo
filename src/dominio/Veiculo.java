public abstract class Veiculo {

    private final Placa placa;
    private Vaga vagaAtual;

    protected Veiculo(Placa placa) {
        if (placa == null) {
            throw new IllegalArgumentException("O veículo precisa de uma placa.");
        }
        this.placa = placa;
    }

    // Ponto de variação: cada subclasse define as vagas compatíveis (RN01)
    public abstract boolean aceitaVaga(TipoVaga tipo);

    // Vaga que o veículo prefere (usada na escolha automática)
    public abstract TipoVaga tipoPreferencial();

    public abstract String nomeDoTipo();

    // Método concreto que usa o método abstrato
    public boolean podeOcupar(Vaga vaga) {
        return aceitaVaga(vaga.tipo());
    }

    // Registra que o veículo foi estacionado numa vaga (RN02)
    public void estacionado(Vaga vaga) {
        if (vagaAtual != null) {
            throw new VeiculoJaEstacionadoException(
                "O veículo " + placa + " já está estacionado na vaga " + vagaAtual.numero() + ".");
        }
        vagaAtual = vaga;
    }

    public void saiuDaVaga() {
        vagaAtual = null;
    }

    public boolean estaEstacionado() {
        return vagaAtual != null;
    }

    public Placa placa() {
        return placa;
    }

    @Override
    public String toString() {
        return nomeDoTipo() + " " + placa;
    }
}
