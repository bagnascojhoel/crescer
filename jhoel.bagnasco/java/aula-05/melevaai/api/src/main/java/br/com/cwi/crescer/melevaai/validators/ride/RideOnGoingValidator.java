package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Corrida;
import br.com.cwi.crescer.melevaai.domain.CorridaStatus;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import org.springframework.stereotype.Component;

@Component
public class RideOnGoingValidator {

    public void validate(Corrida ride) {
        if(ride.getStatus() != CorridaStatus.FINALIZADA)
            throw new ValidacaoNegocioException("Corrida ainda não foi finalizada");
    }
}
