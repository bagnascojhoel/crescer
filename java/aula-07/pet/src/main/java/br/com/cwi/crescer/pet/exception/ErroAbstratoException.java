package br.com.cwi.crescer.pet.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public abstract class ErroAbstratoException extends RuntimeException {

    private String mensagem;
    private HttpStatus status;

    public ErroAbstratoException(String mensagem, HttpStatus status) {
        super(mensagem);
        this.mensagem = mensagem;
        this.status = status;
    }
}
