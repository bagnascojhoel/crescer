package br.com.cwi.crescer.melevaai.exception;

public class MotoristaComCNHVencidaException extends RuntimeException {
    public MotoristaComCNHVencidaException() {
        super("Um motorista não pode dirigir com a carteira de habilitação vencida.");
    }
}
