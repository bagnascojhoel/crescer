package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.controller.MotoristaController;
import br.com.cwi.crescer.melevaai.controller.VeiculoController;
import br.com.cwi.crescer.melevaai.controller.request.VeiculoRequest;
import br.com.cwi.crescer.melevaai.controller.response.VeiculoResponse;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.domain.Veiculo;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.mapper.VeiculoRequestMapper;
import br.com.cwi.crescer.melevaai.mapper.VeiculoResponseMapper;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import br.com.cwi.crescer.melevaai.repository.VeiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    MotoristaRepository motoristaRepository;

    @Autowired
    VeiculoRequestMapper veiculoRequestMapper;

    @Autowired
    VeiculoResponseMapper veiculoResponseMapper;

    public VeiculoResponse salvar(VeiculoRequest veiculoRequest) {
        Motorista proprietario = motoristaRepository
                .findByCpf(veiculoRequest.getCpfMotorista())
                .orElseThrow(() -> new ValidacaoNegocioException());
        Veiculo veiculo = veiculoRequestMapper.apply(veiculoRequest, proprietario);
        return veiculoResponseMapper.apply(veiculo);
    }


}
