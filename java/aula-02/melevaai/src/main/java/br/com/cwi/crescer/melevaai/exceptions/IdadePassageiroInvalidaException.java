package br.com.cwi.crescer.melevaai.exceptions;

public class IdadePassageiroInvalidaException extends RuntimeException {

    public IdadePassageiroInvalidaException() {
        super("Idade do passageiro é inválida");
    }
}
