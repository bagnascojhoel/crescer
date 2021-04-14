package br.com.cwi.crescer.melevaai.validators.driver;

import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DriverLinkedToVehicleValidator {
    public void validate(Optional<Vehicle> veiculo) {
        if(veiculo.isPresent())
            throw new BusynessLogicException("Motorista vinculado a um veículo.");

    }
}
