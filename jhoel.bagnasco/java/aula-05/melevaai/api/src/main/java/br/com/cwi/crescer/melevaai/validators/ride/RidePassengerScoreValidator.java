package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Corrida;
import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import org.springframework.stereotype.Component;

@Component
public class RidePassengerScoreValidator {

    public void validate(Corrida ride) {
        if(ride.getNotaParaPassageiro() != 0)
            throw new ValidacaoNegocioException("Esta corrida já foi avaliada.");
    }
}
