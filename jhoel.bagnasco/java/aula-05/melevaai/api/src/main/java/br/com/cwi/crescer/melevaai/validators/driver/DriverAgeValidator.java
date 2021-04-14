package br.com.cwi.crescer.melevaai.validators.driver;

import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import org.springframework.stereotype.Component;

@Component
public class DriverAgeValidator {

    private static final int MIN_AGE = 18;

    public void validate(Motorista driver) {
         if (driver.getIdade() < MIN_AGE)
            throw new ValidacaoNegocioException("Motorista com idade inválida.");
    }
}
