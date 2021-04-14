package br.com.cwi.crescer.melevaai.validators.driver;

import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DriverAlreadyExistsValidator {
    public void validate(List<Driver> driver) {
        if (!driver.isEmpty())
            throw new BusynessLogicException("Motorista já existe.");
    }
}
