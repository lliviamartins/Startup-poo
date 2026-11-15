| **Código** | **Regra** | **Classe e método responsável** | **Exceção** |
|---|---|---|---|
| RN01 | O veículo só pode ocupar uma vaga compatível com o seu tipo. | `Vaga.ocupar()` | `VagaIncompativelException` |
| RN02 | Uma vaga nunca pode ter dois veículos e um veículo nunca pode ocupar duas vagas. | `Vaga.disponibilidadeDeVaga()` / `Veiculo.estacionado()` | `VagaOcupadaException` / `VeiculoJaEstacionadoException` |
| RN03 | O estacionamento possui 15 minutos de tolerância, cobrança por hora ou fração e teto de diária. | `PoliticaDeTarifa.calcularValor()` | — |
| RN04 | A recarga elétrica será cobrada separadamente por kWh consumido. | `Recarga.calcularValor()` | `RecargaInvalidaException` |
| RN05 | O ticket segue ABERTO → PAGO → ENCERRADO, e a saída só é liberada com ticket pago. | `Ticket.pagar()` / `Cancela.liberarSaida()` | `TicketNaoPagoException` |
| RN06 | A placa deve seguir o padrão Mercosul antigo. | `Placa.padraoMercosulAntigo()` | `PlacaInvalidaException` |
| RN07 | Um veículo não pode possuir dois tickets abertos simultaneamente. | `Estacionamento.registrarEntrada()` | `VeiculoJaEstacionadoException` |
| RN08 | O benefício do mensalista só é aplicado quando o plano está válido. | `Mensalista.possuiPlanoAtivo()` | `PlanoMensalVencidoException` |
