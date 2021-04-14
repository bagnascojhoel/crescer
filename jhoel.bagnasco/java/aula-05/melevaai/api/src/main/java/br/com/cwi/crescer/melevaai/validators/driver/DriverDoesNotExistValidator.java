package br.com.cwi.crescer.melevaai.validators.driver;

import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.exception.RegistroNaoEncontratoException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DriverDoesNotExistValidator {

    public void validate(Optional<Motorista> driver) {
        if (!driver.isPresent())
            throw new RegistroNaoEncontratoException("Nao existe motorista com o cpf informado.");
    }
}
