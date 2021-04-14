package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RideWithPassengerExistsValidator {
    public void validate(List<Ride> rides) {
        if(rides.size() <= 0)
            throw new BusynessLogicException("Passageiro não possui nenhum registro de corrida.");
    }
}
