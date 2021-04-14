package br.com.cwi.crescer.pet2.mapper;

import org.springframework.stereotype.Component;

import br.com.cwi.crescer.pet2.controller.response.IncluirCondominioResponse;
import br.com.cwi.crescer.pet2.domain.Condominio;

@Component
public class IncluirCondominioResponseMapper {

    public IncluirCondominioResponse apply(Condominio novoCondominio) {

        // converte dominio para response
        IncluirCondominioResponse response = new IncluirCondominioResponse();
        response.setIdentificador(novoCondominio.getId());

        return response;
    }
}
