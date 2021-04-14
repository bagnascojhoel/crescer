package br.com.cwi.crescer.melevaai.exception;

public class ProprietarioObrigatorioException extends RuntimeException {
    public ProprietarioObrigatorioException() {
        super("Um proprietário é necessário.");
    }
}
