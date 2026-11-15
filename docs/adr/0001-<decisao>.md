# ADR-0001: Definição da Política de Cobrança do Estacionamento

**Status:** Proposto

**Contexto:** O estacionamento oferece benefícios para clientes mensalistas, mas precisa controlar a validade dos planos para evitar que clientes com mensalidades vencidas continuem utilizando essas vantagens.

**Motivação:** Decidimos que os benefícios só serão concedidos enquanto o plano estiver válido. Assim, o sistema deverá verificar a validade antes de liberar qualquer benefício.

**Consequências:**
- Evitar benefícios para planos vencidos.
- Facilitar o controle dos mensalistas.
- Será necessário verificar a validade do plano durante a utilização.
