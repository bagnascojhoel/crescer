package br.com.cwi.crescer.melevaai.mapper.driver;

import br.com.cwi.crescer.melevaai.controller.response.DriverResponse;
import br.com.cwi.crescer.melevaai.domain.Driver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToDriverResponseMapper {

    @Autowired
    ModelMapper modelMapper;

    public DriverResponse map(Driver driver) {
        return modelMapper.map(driver, DriverResponse.class);
    }
}
