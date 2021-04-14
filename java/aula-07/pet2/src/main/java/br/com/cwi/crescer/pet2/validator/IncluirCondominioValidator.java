package br.com.cwi.crescer.pet2.validator;

import org.springframework.stereotype.Component;

import br.com.cwi.crescer.pet2.controller.request.IncluirCondominioRequest;
import br.com.cwi.crescer.pet2.exception.NegocioException;

@Component
public class IncluirCondominioValidator {

    public void accept(IncluirCondominioRequest request) {

        // Validação simples (não tem dependência além do request)
        if (request.getConfig().isAceitaPet()
            && (request.getConfig().getTiposPet() == null
            || request.getConfig().getTiposPet().isEmpty())
        ) {
            throw new NegocioException("Deve informar a lista de tipos");
        }
    }
}
