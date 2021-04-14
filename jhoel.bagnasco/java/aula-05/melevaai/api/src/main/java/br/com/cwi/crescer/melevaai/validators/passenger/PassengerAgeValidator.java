package br.com.cwi.crescer.melevaai.validators.passenger;

import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import org.springframework.stereotype.Component;

@Component
public class PassengerAgeValidator {

    private static final int IDADE_MINIMA = 16;

    public void validate(int age) {
        if (age < IDADE_MINIMA)
            throw new ValidacaoNegocioException("Passageiro com idade inválida.");

    }
}
