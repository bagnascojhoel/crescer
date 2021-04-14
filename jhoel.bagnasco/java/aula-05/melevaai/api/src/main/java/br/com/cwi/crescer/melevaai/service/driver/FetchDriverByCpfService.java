package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.controller.response.MotoristaResponse;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import br.com.cwi.crescer.melevaai.validators.driver.DriverDoesNotExistValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FetchDriverByCpfService {

    @Autowired MotoristaRepository driverRepository;

    @Autowired
    DriverDoesNotExistValidator driverDoesNotExistValidator;

    @Autowired ModelMapper modelMapper;

    public MotoristaResponse fetch(String cpf) {
        Optional<Motorista> driver = driverRepository.findByCpf(cpf);

        driverDoesNotExistValidator.validate(driver);

        return modelMapper.map(driver.get(), MotoristaResponse.class);
    }
}
