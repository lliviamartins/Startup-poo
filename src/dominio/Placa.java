package dominio;
//record = estrutura imutavel
public record Placa (String valor) {
  public Placa {
        if (valor == null || !valor.matches("[A-Za-z]{3}[0-9]{4}")) {
            throw new IllegalArgumentException(
                "Placa inválida! Utilize o formato ABC1234."
            );
        }

        valor = valor.toUpperCase();
    }
}
