package br.com.cwi.crescer.heranca.controller.request;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PJRequest {

    @NotEmpty
    private String nome;

    @CNPJ
    private String cnpj;

    @NotEmpty
    private String fantasia;
}
