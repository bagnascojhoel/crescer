package br.com.cwi.crescer.projeto1.exception;

public class IdadePassageiroInvalidaException extends RuntimeException {

    public IdadePassageiroInvalidaException() {
        super("Idade do passageiro é inválida");
    }
}
