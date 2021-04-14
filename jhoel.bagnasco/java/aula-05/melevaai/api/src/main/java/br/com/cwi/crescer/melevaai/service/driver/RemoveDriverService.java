package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import br.com.cwi.crescer.melevaai.repository.VeiculoRepository;
import br.com.cwi.crescer.melevaai.validators.driver.DriverDoesNotExistValidator;
import br.com.cwi.crescer.melevaai.validators.driver.DriverLinkedToVehicleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RemoveDriverService {

    @Autowired MotoristaRepository motoristaRepository;

    @Autowired VeiculoRepository veiculoRepository;

    @Autowired DriverDoesNotExistValidator driverDoesNotExistValidator;

    @Autowired DriverLinkedToVehicleValidator driverLinkedToVehicleValidator;

    public void remove(String cpf) {
        Optional<Motorista> motorista = motoristaRepository.findByCpf(cpf);

        driverDoesNotExistValidator.validate(motorista);

        driverLinkedToVehicleValidator.validate(veiculoRepository.findByOwnerCpf(motorista.get().getCpf().getNumero()));

        motoristaRepository.remove(motorista.get());
    }
}
