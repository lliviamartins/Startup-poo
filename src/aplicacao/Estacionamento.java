import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Veiculo;

public class Estacionamento {

    private String nome;
    private String politicaDeTarifa;
    private List<Permanencia> tickets;
    private List<Vaga> vagas;
    private List<Pagamento> pagamentos;
    private CalculadoraTarifa calculadoraTarifa;

    // Construtor
    public Estacionamento(String nome, String politicaDeTarifa, List<Permanencia> tickets, List<Vaga> vagas, List<Pagamento> pagamentos) {
        this.nome = nome;
        this.politicaDeTarifa = politicaDeTarifa;
        this.tickets = new ArrayList<>(tickets);
        this.vagas = new ArrayList<>(vagas);
        this.pagamentos = new ArrayList<>();
    }

    // Verifica se o veículo já está estacionado
    public boolean veiculoEstaEstacionado(Veiculo veiculo) {

        for (Permanencia permanencia : tickets) {

            if (permanencia.getVeiculo().equals(veiculo)
                    && permanencia.getStatus() == StatusPermanencia.ATIVA) {
                return true;
            }
        }

        return false;
    }

    // Verifica se existe alguma vaga disponível
    public boolean possuiVagaDisponivel() {

        for (Vaga vaga : vagas) {

            if (vaga.isDisponivel()) {
                return true;
            }
        }

        return false;
    }

    // Procura uma vaga disponível
    public Vaga buscarVagaDisponivel()
            throws VagaIndisponivelException {

        for (Vaga vaga : vagas) {

            if (vaga.isDisponivel()) {
                return vaga;
            }
        }

        throw new VagaIndisponivelException(
                "Não existem vagas disponíveis."
        );
    }

    // Registra a entrada de um veículo
    public Permanencia registrarEntrada(Veiculo veiculo)
            throws VagaIndisponivelException,
                  VeiculoJaEstacionadoException {

        if (veiculoEstaEstacionado(veiculo)) {
            throw new VeiculoJaEstacionadoException(
                    "Este veículo já está estacionado."
            );
        }

        Vaga vaga = buscarVagaDisponivel();

        Permanencia permanencia = new Permanencia(veiculo, vaga);

        vaga.ocupar();

        tickets.add(permanencia);

        return permanencia;
    }

    // Localiza a permanência ativa de um veículo
    public Permanencia buscarPermanenciaAtiva(Veiculo veiculo) {

        for (Permanencia permanencia : tickets) {

            if (permanencia.getVeiculo().equals(veiculo)
                    && permanencia.getStatus() == StatusPermanencia.ATIVA) {
                return permanencia;
            }
        }

        return null;
    }

    // Registra a saída e gera o pagamento
    public Pagamento registrarSaida(Veiculo veiculo) {

        Permanencia permanencia = buscarPermanenciaAtiva(veiculo);

        if (permanencia == null) {
            throw new IllegalArgumentException(
                    "Este veículo não possui permanência ativa."
            );
        }

        permanencia.registrarSaida();

        double valor = calculadoraTarifa.calcularTarifa(permanencia);

        Pagamento pagamento = new Pagamento(permanencia, valor);

        pagamentos.add(pagamento);

        permanencia.getVaga().liberar();

        return pagamento;
    }

    // Retorna todas as vagas
    public List<Vaga> listarVagas() {
        return Collections.unmodifiableList(vagas);
    }

    // Retorna todas as permanências (tickets)
    public List<Permanencia> listarPermanencias() {
        return Collections.unmodifiableList(tickets);
    }

    // Retorna todos os pagamentos
    public List<Pagamento> listarPagamentos() {
        return Collections.unmodifiableList(pagamentos);
    }

    // Retorna a quantidade de vagas disponíveis
    public int quantidadeVagasDisponiveis() {

        int quantidade = 0;

        for (Vaga vaga : vagas) {

            if (vaga.isDisponivel()) {
                quantidade++;
            }
        }

        return quantidade;
    }

    // Retorna a quantidade de veículos estacionados
    public int quantidadeVeiculosEstacionados() {

        int quantidade = 0;

        for (Permanencia permanencia : tickets) {

            if (permanencia.getStatus() == StatusPermanencia.ATIVA) {
                quantidade++;
            }
        }

        return quantidade;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getPoliticaDeTarifa() {
        return politicaDeTarifa;
    }

    public List<Vaga> getVagas() {
        return Collections.unmodifiableList(vagas);
    }

    public List<Permanencia> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public List<Pagamento> getPagamentos() {
        return Collections.unmodifiableList(pagamentos);
    }

    // Define a calculadora de tarifas
    public void setCalculadoraTarifa(CalculadoraTarifa calculadoraTarifa) {
        this.calculadoraTarifa = calculadoraTarifa;
    }
}
