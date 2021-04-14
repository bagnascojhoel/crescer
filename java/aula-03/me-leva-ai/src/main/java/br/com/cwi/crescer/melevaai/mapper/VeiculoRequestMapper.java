package br.com.cwi.crescer.melevaai.mapper;

import br.com.cwi.crescer.melevaai.controller.request.VeiculoRequest;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.domain.Veiculo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VeiculoRequestMapper {

    public Veiculo apply(VeiculoRequest veiculoRequest, Motorista proprietario){
        ModelMapper modelMapper = new ModelMapper();
        // de veiculoRequest para veiculo
        Veiculo veiculo = modelMapper.map(veiculoRequest, Veiculo.class);
        veiculo.setProprietario(proprietario);
        return veiculo;
    }

}
