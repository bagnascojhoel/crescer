package br.com.cwi.crescer.melevaai.validators.passenger;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PassengerExistsValidator {
    public void validate(List<Passenger> passageiro) {
        if (!passageiro.isEmpty())
            throw new BusynessLogicException("Passageiro já adicionado.");
    }
}
