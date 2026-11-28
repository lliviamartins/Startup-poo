# MaLi Parking - Estacionamento inteligente (AV2 - POO Java)

**Domínio escolhido:** D3 · Mobilidade — Estacionamento Inteligente.

Núcleo de domínio de um estacionamento: vagas por tipo (carro, moto, elétrico com recarga e PcD), tickets com
ciclo de vida (ABERTO → PAGO → ENCERRADO), tarifa com tolerância, hora ou fração e teto de diária, recarga
elétrica por kWh, mensalistas e cancela. Depois do pagamento a vaga fica **aguardando saída** até a cancela abrir.
Java 21 puro, sem bibliotecas externas.

## Integrantes
- Lívia Pereira Martins dos Santos - RA: **2610654**
- Marina Lopes Roberto - RA: **2601485**

## Como compilar e executar

Entre na pasta `src` e rode:

**Windows (PowerShell ou CMD)**

    javac -encoding UTF-8 -d ..\out dominio\*.java dominio\excecoes\*.java aplicacao\*.java app\*.java
    java -cp ..\out app.Main

**Linux / macOS**

    javac -encoding UTF-8 -d ../out dominio/*.java dominio/excecoes/*.java aplicacao/*.java app/*.java
    java -cp ../out app.Main

Ou abra o projeto em uma IDE (IntelliJ, Eclipse, VS Code), marque `src` como pasta de código-fonte e rode `app.Main`.

> Os dados ficam em `dados/` (CSV), na pasta de onde o programa foi executado. Na primeira execução são criados
> dados de exemplo. Para recomeçar do zero, apague a pasta `dados`.
> O tempo é simulado: **30 segundos reais = 1 hora** de estacionamento.

## Menu

| Opção | O que faz |
|---|---|
| 1 | Cadastrar veículo (e, se quiser, contratar plano de mensalista e já entrar) |
| 2 | Registrar entrada (avulso ou mensalista) |
| 3 | Registrar recarga elétrica (troca para vaga de recarga se preciso) |
| 4 | Pagar ticket (a vaga passa a AGUARDANDO SAÍDA) |
| 5 | Liberar saída na cancela (encerra o ticket e libera a vaga) |
| 6 | Ver mapa de vagas (Livre / OCUPADA / AGUARD. SAÍDA) |
| 7 | Listar tickets por horário de entrada (ordem natural - `Comparable`) |
| 8 | Listar veículos por placa (ordem alternativa - `Comparator`) |
| 9 | Relatórios gerenciais com Streams (6 relatórios) |
| 10 | Histórico de eventos da execução (Observer) |
| 0 | Sair |

## Estrutura (arquitetura em camadas — desafio F)

```
src/
├── dominio/            regras de negócio (não usa Scanner nem imprime nada)
│   ├── Veiculo (abstrata) → Carro, Moto, Eletrico, CarroPcD
│   ├── Vaga, TipoVaga (enum), SituacaoVaga (enum)
│   ├── Ticket (Comparable), StatusTicket (enum), Cancela, Estacionamento
│   ├── PoliticaDeTarifa (interface) → TarifaComum, TarifaMensalista
│   ├── Cobravel (interface) → Permanencia, Recarga
│   ├── Placa, Dinheiro, EventoDoEstacionamento (records)
│   ├── Notificador (interface), TipoEvento (enum), Mensalista, ComparadorVeiculoPorPlaca
│   └── excecoes/       EstacionamentoException + 9 exceções com nome do negócio
├── aplicacao/          RepositorioCsv, DadosExemplo, RelatoriosGerenciais, ItemDeRanking, RegistroDeEventos
└── app/                Main, Menu, NotificadorConsole, Cores
docs/
├── glossario.md        linguagem ubíqua (R01)
├── regras.md           regras + matriz de rastreabilidade com arquivo:linha (R02)
├── requisitos.md       conferência R01–R12 e desafios, com arquivo:linha
├── diagrama-classes.png (+ .svg, fonte .puml e .dot)
├── adr/                ADR-0001, ADR-0002, ADR-0003
└── pdr/                PDR-0001 (entrevista do desafio H)
```

## Desafios Vá Além escolhidos

Apresentaremos **D, E, F e H**. B e C também estão prontos e ficam como reserva.
Arquivo e linha de cada um estão em `docs/requisitos.md`.

| Desafio | Onde está |
|---|---|
| **D · Relatórios com Streams** | `aplicacao/RelatoriosGerenciais.java`: 6 relatórios com `filter`, `map`, `sorted`, `Collectors.groupingBy` (faturamento por tipo de cobrança, ocupação por tipo de vaga, ranking por valor gasto, energia por elétrico, permanência média, mensalistas vencidos). Menu opção 9. |
| **E · Eventos de domínio** | `dominio/Notificador.java` (interface), `Estacionamento.adicionarNotificador()` e `avisar()`; ouvintes `app/NotificadorConsole.java` e `aplicacao/RegistroDeEventos.java`. Eventos: cadastro, plano, quitação, entrada, troca de vaga, recarga, pagamento e saída. Menu opção 10. |
| **F · Arquitetura em camadas** | Pacotes `dominio`, `aplicacao` e `app`. O domínio não importa `Scanner` nem usa `System.out`. Ver ADR-0003. |
| **H · Entrevista com especialista** | `docs/pdr/PDR-0001-entrevista-especialista.md` — **entrevista simulada com IA (declarado)**, com regras aceitas (RN07\*–RN11\*) e rejeitadas. |
| B · Persistência (reserva) | `aplicacao/RepositorioCsv.java` (CSV, try-with-resources, `IOException`). |
| C · Strategy (reserva) | `dominio/PoliticaDeTarifa.java` com `TarifaComum` e `TarifaMensalista` escolhidas na entrada. Ver ADR-0002. |

## Uso de IA generativa

Parte do código, da documentação e a entrevista do desafio H foram produzidas com apoio de IA generativa (Claude).
Cada integrante declara no relatório individual em quais trechos usou, para quê e o que entendeu e ajustou.

