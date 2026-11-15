| **Termo do negócio** | **Significado acordado** | **Elemento no código** |
|---|---|---|
| Veículo | Meio de transporte que utiliza o estacionamento. | `Veículo` |
| Vaga | Espaço destinado ao estacionamento de um veículo. | `Vaga` |
| Vaga compatível | Vaga adequada à categoria do veículo. | `vaga.tipo()` |
| Ocupação | Período em que uma vaga está sendo utilizada. | `vaga.ocupa()` |
| Ticket | Registro da entrada e permanência do veículo. | `Ticket` |
| Ticket aberto | Ticket de um veículo que ainda não finalizou o estacionamento. | `StatusTicket.ABERTO` |
| Tarifa | Valor cobrado pelo estacionamento. | `PoliticaDeTarifa` |
| Tolerância | Período inicial de até 15 minutos sem cobrança. | `calcularValor()` |
| Teto da diária | Valor máximo cobrado pelo estacionamento em um dia. | `PoliticaDeTarifa` |
| Mensalista | Cliente que possui um plano mensal de estacionamento. | `Mensalista` |
| Recarga elétrica | Energia fornecida ao veículo elétrico, cobrada por kWh. | `Recarga` |
| kWh | Unidade de medida da energia elétrica consumida. | `Recarga.energiaConsumida` |
