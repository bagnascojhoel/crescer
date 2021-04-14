package br.com.cwi.crescer.tb01.controller.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaRequest {

    @NotEmpty
    private String nome;

    @NotNull
    @CPF(message = "inválido")
    private String cpf;
}
