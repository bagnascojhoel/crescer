package br.com.cwi.crescer.melevaai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MotoristaNaoExisteException extends RuntimeException {
    public MotoristaNaoExisteException() {
        super("O motorista informado não existe.");
    }
}
