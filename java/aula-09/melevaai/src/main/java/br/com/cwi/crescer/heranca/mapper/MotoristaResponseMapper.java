package br.com.cwi.crescer.heranca.mapper;

import org.springframework.stereotype.Component;

import br.com.cwi.crescer.heranca.controller.response.MotoristaResponse;
import br.com.cwi.crescer.heranca.domain.Motorista;

@Component
public class MotoristaResponseMapper {

    public MotoristaResponse converter(Motorista motorista) {

        MotoristaResponse response = new MotoristaResponse();
        response.setId(motorista.getId());
        response.setNome(motorista.getNome());

        return response;
    }

}
