package br.com.cwi.crescer.tb01.exception;

import org.springframework.http.HttpStatus;

public class NaoEncontradoException extends ErroAbstratoException {

    public NaoEncontradoException(String mensagem) {
        super(mensagem, HttpStatus.NOT_FOUND);
    }
}
