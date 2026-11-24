package Startup

import java.util.ArrayList;
import java.util.List;



public class Estacionamento {
    String nome;
    String politicaDeTarifa;

    // as listas das vagas criadas e tickets gerados
    List<Vaga> vagas;
    List<Ticket> tickets;

    public Estacionamento(String nome,String politicaDeTarifa, List tickets, List vagas){
        this.nome = nome;
        this.politicaDeTarifa = politicaDeTarifa;
        this.tickets = tickets;
        this.vagas = vagas;
    }
}
