package br.com.cwi.crescer.pet.exception;

import org.springframework.http.HttpStatus;

public class NegocioException extends ErroAbstratoException {

    public NegocioException(String mensagem) {
        super(mensagem, HttpStatus.BAD_REQUEST);
    }
}
