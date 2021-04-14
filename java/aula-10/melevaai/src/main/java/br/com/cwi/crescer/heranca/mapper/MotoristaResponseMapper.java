package br.com.cwi.crescer.heranca.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cwi.crescer.heranca.controller.response.MotoristaResponse;
import br.com.cwi.crescer.heranca.domain.Motorista;

@Component
public class MotoristaResponseMapper {

//    @Autowired
//    private ModelMapperConfig modelMapper;

    @Autowired
    private ModelMapper modelMapper;

    public MotoristaResponse converter(Motorista motorista) {

        MotoristaResponse response = modelMapper.map(motorista, MotoristaResponse.class);

        return response;
    }

}
