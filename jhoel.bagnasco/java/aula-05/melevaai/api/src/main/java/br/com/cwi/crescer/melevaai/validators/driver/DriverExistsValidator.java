package br.com.cwi.crescer.melevaai.validators.driver;

import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DriverExistsValidator {
    public void validate(Optional<Motorista> driver) {
        if (driver.isPresent())
            throw new ValidacaoNegocioException("Motorista já existe.");
    }
}
