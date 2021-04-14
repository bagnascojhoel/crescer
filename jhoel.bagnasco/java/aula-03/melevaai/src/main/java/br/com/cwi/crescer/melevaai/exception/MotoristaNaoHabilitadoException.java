package br.com.cwi.crescer.melevaai.exception;

public class MotoristaNaoHabilitadoException extends RuntimeException {

    public MotoristaNaoHabilitadoException() {
        super("A carteira de habilitação nacional do proprietário não é compatível com a categoria do veículo.");
    }
}
