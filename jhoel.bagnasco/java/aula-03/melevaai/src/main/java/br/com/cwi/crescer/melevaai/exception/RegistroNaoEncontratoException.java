package br.com.cwi.crescer.melevaai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegistroNaoEncontratoException extends RuntimeException {

    private static final String TIPO_REGISTRO_PADRAO = "";

    public RegistroNaoEncontratoException() {
        super("O registro" + TIPO_REGISTRO_PADRAO + " não foi encontrado.");
    }

    public RegistroNaoEncontratoException(String tipoRegistro) {
        super("O registro" + tipoRegistro + " não foi encontrado.");
    }
}
