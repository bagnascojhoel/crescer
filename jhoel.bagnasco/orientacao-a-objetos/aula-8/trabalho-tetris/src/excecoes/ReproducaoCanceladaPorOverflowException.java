package excecoes;

public class ReproducaoCanceladaPorOverflowException extends Exception {
    public ReproducaoCanceladaPorOverflowException() {
        super("Reproducao cancelada por um bloco ter transbordado o tamanho do quadro.");
    }
}
