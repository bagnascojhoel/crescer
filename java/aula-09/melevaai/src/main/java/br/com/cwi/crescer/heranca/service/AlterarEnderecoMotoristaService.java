package br.com.cwi.crescer.heranca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.heranca.controller.request.AlterarEnderecoRequest;
import br.com.cwi.crescer.heranca.controller.response.MotoristaResponse;
import br.com.cwi.crescer.heranca.domain.Motorista;
import br.com.cwi.crescer.heranca.mapper.MotoristaResponseMapper;
import br.com.cwi.crescer.heranca.repository.MotoristaRepository;

@Service
public class AlterarEnderecoMotoristaService {

    @Autowired
    private BuscarMotoristaPorIdService buscarMotoristaPorIdService;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private MotoristaResponseMapper responseMapper;

    public MotoristaResponse alterar(Integer id, AlterarEnderecoRequest request) {

        Motorista motorista = buscarMotoristaPorIdService.buscar(id);

        String novoEndereco = request.getNovoEndereco();
        motorista.setEndereco(novoEndereco);

        Motorista motoristaAtualizado = motoristaRepository.save(motorista);

        return responseMapper.converter(motoristaAtualizado);
    }
}
