package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.controller.request.MotoristaRequest;
import br.com.cwi.crescer.melevaai.controller.response.MotoristaResponse;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import br.com.cwi.crescer.melevaai.validators.PersonCpfValidator;
import br.com.cwi.crescer.melevaai.validators.driver.DriverAgeValidator;
import br.com.cwi.crescer.melevaai.validators.driver.DriverExistsValidator;
import br.com.cwi.crescer.melevaai.validators.driver.DriverCnhValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddDriverService {

    @Autowired MotoristaRepository driverRepository;

    @Autowired ModelMapper modelMapper;

    @Autowired
    DriverExistsValidator driverExistsValidator;

    @Autowired DriverAgeValidator driverAgeValidator;

    @Autowired DriverCnhValidator driverCnhValidator;

    @Autowired PersonCpfValidator personCpfValidator;

    public MotoristaResponse add(MotoristaRequest request) {

        Motorista driver = modelMapper.map(request, Motorista.class);

        driverExistsValidator.validate(driverRepository.findByCpf(driver.getCpf().getNumero()));

        driverAgeValidator.validate(driver);

        driverCnhValidator.validate(driver);

        personCpfValidator.validate(driver.getCpf().getNumero());

        driverRepository.add(driver);

        MotoristaResponse response = modelMapper.map(driver, MotoristaResponse.class);

        return response;
    }
}
