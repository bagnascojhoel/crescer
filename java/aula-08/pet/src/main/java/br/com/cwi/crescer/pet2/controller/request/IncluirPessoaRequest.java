package br.com.cwi.crescer.pet2.controller.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.cwi.crescer.pet2.domain.Cor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IncluirPessoaRequest {

    @NotEmpty
    private String nome;

    @NotNull
    private Cor cor;

    @NotNull
    private Integer idCondominio;
}
