package br.com.cwi.crescer.melevaai.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AbstractException extends RuntimeException {

    private final HttpStatus status;

    private final String error;

    public AbstractException(HttpStatus status, String error) {
        super(error);
        this.error = error;
        this.status = status;
    }
}
