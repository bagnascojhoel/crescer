package br.com.cwi.crescer.melevaai.mapper.driver;

import br.com.cwi.crescer.melevaai.controller.request.DriverRequest;
import br.com.cwi.crescer.melevaai.domain.Driver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FromDriverRequestMapper {

    @Autowired
    ModelMapper modelMapper;

    public Driver map(DriverRequest driverRequest) {
        return modelMapper.map(driverRequest, Driver.class);
    }
}
