package br.com.cwi.crescer.melevaai.validators.driver;

import br.com.cwi.crescer.melevaai.domain.Veiculo;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DriverLinkedToVehicleValidator {
    public void validate(Optional<Veiculo> veiculo) {
        if(veiculo.isPresent())
            throw new ValidacaoNegocioException("Motorista vinculado a um veículo.");

    }
}
