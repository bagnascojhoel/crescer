package br.com.cwi.crescer.pet.controller.request;

import java.util.List;

import br.com.cwi.crescer.pet.domain.Tipo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ConfiguracaoCondominioRequest {

    private boolean aceitaPet;
    private List<Tipo> tiposPet;
}
