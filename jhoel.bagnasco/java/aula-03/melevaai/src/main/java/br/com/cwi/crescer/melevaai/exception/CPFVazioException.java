package br.com.cwi.crescer.melevaai.exception;

public class CPFVazioException extends RuntimeException {
    public CPFVazioException() {
        super("CPF não pode ser vazio.");
    }
}
