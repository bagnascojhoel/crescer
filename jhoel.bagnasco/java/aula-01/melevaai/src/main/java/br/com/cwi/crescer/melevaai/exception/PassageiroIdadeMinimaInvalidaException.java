package br.com.cwi.crescer.melevaai.exception;

public class PassageiroIdadeMinimaInvalidaException extends RuntimeException {
    public PassageiroIdadeMinimaInvalidaException() {
        super("Passageiro com idade mínima invalida.");
    }
}
