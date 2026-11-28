# Glossário (linguagem ubíqua) — R01

Os termos abaixo são as palavras do negócio "estacionamento" e aparecem **com o mesmo nome** no código
(classes, métodos, enums e exceções). Não usamos nomes genéricos como `Manager`, `Helper` ou `Data`.

| Termo do negócio | Significado acordado | Elemento no código |
|---|---|---|
| Estacionamento | O negócio: reúne vagas, veículos, mensalistas e tickets e aplica as regras. | `class Estacionamento` |
| Veículo | Meio de transporte que usa o estacionamento; cada tipo decide em que vaga pode ficar. | `abstract class Veiculo` → `Carro`, `Moto`, `Eletrico`, `CarroPcD` |
| Placa | Identificação do veículo, no padrão Mercosul (ABC1D23) ou antigo (ABC1234). | `record Placa` |
| Vaga | Espaço numerado onde cabe um único veículo. | `class Vaga` |
| Tipo de vaga | Categoria da vaga: carro, moto, elétrico (com recarga) ou PcD. | `enum TipoVaga` |
| Vaga compatível | Vaga cujo tipo o veículo aceita. | `Veiculo.aceitaVaga()`, `Veiculo.podeOcupar()`, `Estacionamento.vagasCompativeis()` |
| Ocupar / liberar a vaga | Colocar o veículo na vaga na entrada / tirá-lo quando a cancela libera. | `Vaga.ocupar()`, `Vaga.liberar()` |
| Situação da vaga | Livre, ocupada ou aguardando saída. | `enum SituacaoVaga`, `Vaga.situacao()` |
| Aguardando saída | Vaga cujo ticket já foi pago, mas o veículo ainda não passou pela cancela. Ninguém mais pode usá-la. | `SituacaoVaga.AGUARDANDO_SAIDA`, `Vaga.marcarAguardandoSaida()` |
| Ticket | Registro da entrada, do pagamento e da saída de um veículo. | `class Ticket` |
| Status do ticket | Ciclo de vida do ticket: aberto → pago → encerrado. | `enum StatusTicket` |
| Registrar entrada | Abrir um ticket e ocupar uma vaga compatível. | `Estacionamento.registrarEntrada()` |
| Pagar | Calcular o valor (permanência + recargas) e passar o ticket para PAGO. | `Ticket.pagar()`, `Estacionamento.pagarTicket()` |
| Cancela / liberar saída | Barreira que só abre para ticket pago; ao abrir, o ticket é encerrado e a vaga fica livre. | `class Cancela`, `Cancela.liberarSaida()`, `Ticket.encerrar()` |
| Permanência | Tempo cobrado: da entrada até o pagamento. | `class Permanencia`, `Ticket.minutosDePermanencia()` |
| Política de tarifa | Regra de cálculo do valor da permanência; pode ser trocada (avulso ou mensalista). | `interface PoliticaDeTarifa` → `TarifaComum`, `TarifaMensalista` |
| Tolerância | Primeiros 15 minutos sem cobrança. | `TarifaComum.TOLERANCIA_EM_MINUTOS` |
| Hora ou fração | Qualquer pedaço de hora iniciado é cobrado como hora cheia. | `TarifaComum.calcularValor()` |
| Teto da diária | Valor máximo cobrado por dia de permanência. | `TarifaComum.tetoDaDiaria` |
| Cobrável | Tudo que entra na conta do ticket (permanência, recarga). | `interface Cobravel` |
| Recarga elétrica | Energia fornecida ao elétrico na vaga de recarga, cobrada à parte. | `class Recarga`, `Ticket.adicionarRecarga()` |
| kWh | Unidade da energia consumida na recarga. | `Recarga.energiaConsumida`, `Estacionamento.valorDoKwh()` |
| Mensalista | Cliente com plano mensal; não paga permanência enquanto o plano estiver válido. | `class Mensalista`, `TarifaMensalista` |
| Plano válido / vencido | O plano vale até a data de validade; depois disso o benefício é recusado. | `Mensalista.possuiPlanoAtivo()`, `PlanoMensalVencidoException` |
| Mensalidade em débito | Mensalidades atrasadas que o mensalista precisa quitar para voltar a ter o benefício. | `Mensalista.valorDoDebito()`, `Estacionamento.quitarMensalidade()` |
| Dinheiro | Valor em reais, nunca negativo, com 2 casas. | `record Dinheiro` |
| Evento do estacionamento | Aviso de que algo relevante aconteceu (entrada, pagamento, saída...). | `record EventoDoEstacionamento`, `enum TipoEvento` |
| Notificador | Quem quer ser avisado dos eventos (console, histórico). | `interface Notificador` → `NotificadorConsole`, `RegistroDeEventos` |
| Relatório gerencial | Visão consolidada para o dono do negócio (faturamento, ocupação, ranking...). | `class RelatoriosGerenciais` |
