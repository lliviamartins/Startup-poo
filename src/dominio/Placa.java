public record Placa(String valor) {

    public Placa {
        if (valor == null) {
            throw new PlacaInvalidaException("A placa é obrigatória.");
        }
        valor = valor.trim().toUpperCase();
        if (!padraoMercosulAntigo(valor)) {
            throw new PlacaInvalidaException(
                "Placa inválida: " + valor + ". Use o formato ABC1234 ou ABC1D23.");
        }
    }

    public static boolean padraoMercosulAntigo(String texto) {
        boolean antigo = texto.matches("[A-Z]{3}[0-9]{4}");
        boolean mercosul = texto.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}");
        return antigo || mercosul;
    }

    @Override
    public String toString() {
        return valor;
    }
}
