package br.com.cwi.crescer.heranca.controller.request;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlterarEnderecoRequest {

    @NotEmpty
    private String novoEndereco;
}
