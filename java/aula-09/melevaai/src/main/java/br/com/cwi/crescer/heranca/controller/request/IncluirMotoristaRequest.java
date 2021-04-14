package br.com.cwi.crescer.heranca.controller.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncluirMotoristaRequest {

    @NotNull
    private String cpf;

    @NotNull
    private String nome;

    @NotNull
    private String numeroCnh;
}
