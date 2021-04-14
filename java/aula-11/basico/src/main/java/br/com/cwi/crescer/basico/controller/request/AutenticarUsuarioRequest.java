package br.com.cwi.crescer.basico.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutenticarUsuarioRequest {

    private String email;
    private String senha;
}
