package br.com.cwi.crescer.pet2.controller.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IncluirCondominioRequest {

    @NotEmpty
    private String nome;

    @NotNull
    private ConfiguracaoCondominioRequest config;
}
