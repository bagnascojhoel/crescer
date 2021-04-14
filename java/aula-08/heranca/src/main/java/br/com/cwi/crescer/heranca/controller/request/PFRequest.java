package br.com.cwi.crescer.heranca.controller.request;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PFRequest {

    @NotEmpty
    private String nome;

    @CPF
    private String cpf;
}
