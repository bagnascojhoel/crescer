package br.com.cwi.crescer.melevaai.mapper;

import br.com.cwi.crescer.melevaai.controller.response.VeiculoResponse;
import br.com.cwi.crescer.melevaai.domain.Veiculo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VeiculoResponseMapper {

    public VeiculoResponse apply(Veiculo veiculo){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(veiculo, VeiculoResponse.class);
    }

}
