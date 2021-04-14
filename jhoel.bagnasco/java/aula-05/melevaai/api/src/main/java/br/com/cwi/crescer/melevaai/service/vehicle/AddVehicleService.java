package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.controller.MotoristaController;
import br.com.cwi.crescer.melevaai.controller.request.VeiculoRequest;
import br.com.cwi.crescer.melevaai.controller.response.VeiculoResponse;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.domain.Veiculo;
import br.com.cwi.crescer.melevaai.exception.RegistroNaoEncontratoException;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.repository.VeiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddVehicleService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    VeiculoRepository veiculoRepository;

    public VeiculoResponse add(VeiculoRequest veiculoRequest) {

        Motorista proprietario = MotoristaController.motoristaList
                .stream()
                .filter(motorista -> motorista.getCpf().getNumero().equals(veiculoRequest.getCPFProprietario()))
                .findFirst()
                .orElseThrow(() -> new RegistroNaoEncontratoException("Motorista"));

        System.out.println(proprietario.getCpf());

        Veiculo veiculo = modelMapper.map(veiculoRequest, Veiculo.class);

        //TODO: categorias iguais as da vida real??
        if(veiculo.getCategoria() != proprietario.getCnh().getCategoria())
            throw new ValidacaoNegocioException("O proprietário não é apto a dirigir este veiculo.");

        veiculo.setProprietario(proprietario);

        veiculoRepository.add(veiculo);

        VeiculoResponse response = modelMapper.map(veiculo, VeiculoResponse.class);

        return response;
    }
}
