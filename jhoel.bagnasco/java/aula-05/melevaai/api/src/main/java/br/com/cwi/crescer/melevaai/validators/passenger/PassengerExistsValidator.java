package br.com.cwi.crescer.melevaai.validators.passenger;

import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PassengerExistsValidator {
    public void validate(Optional<Passageiro> passageiro) {
        if (passageiro.isPresent())
            throw new ValidacaoNegocioException("Passageiro já adicionado.");
    }
}
