package br.com.cwi.crescer.pet2.controller.request;

import java.util.List;

import br.com.cwi.crescer.pet2.domain.Tipo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ConfiguracaoCondominioRequest {

    private boolean aceitaPet;
    private List<Tipo> tiposPet;
}
