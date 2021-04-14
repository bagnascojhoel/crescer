package br.com.cwi.crescer.melevaai.validators.passenger;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PassengerDoesNotExistValidator {
    public void validate(List<Passenger> passageiroOptional) {
        if (passageiroOptional.isEmpty())
            throw new NotFoundException("Não existe passageiro com o CPF informado.");
    }
}
