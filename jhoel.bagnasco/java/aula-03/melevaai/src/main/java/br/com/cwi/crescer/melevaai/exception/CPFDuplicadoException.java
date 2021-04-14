package br.com.cwi.crescer.melevaai.exception;

public class CPFDuplicadoException extends RuntimeException {
    public CPFDuplicadoException() {
        super("O CPF não pode ser duplicado.");
    }
}
