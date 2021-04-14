package br.com.cwi.crescer.tb01.exception;

import org.springframework.http.HttpStatus;

public class NegocioException extends ErroAbstratoException {

    public NegocioException(String mensagem) {
        super(mensagem, HttpStatus.BAD_REQUEST);
    }
}
