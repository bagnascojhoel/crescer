package br.com.cwi.crescer.melevaai.validators.passenger;

import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.exception.RegistroNaoEncontratoException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PassengerDoesNotExistValidator {
    public void validate(Optional<Passageiro> passageiroOptinal) {
        if (!passageiroOptinal.isPresent())
            throw new RegistroNaoEncontratoException("Não existe passageiro com o CPF informado.");
    }
}
