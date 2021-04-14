package br.com.cwi.crescer.melevaai.service.motorista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.melevaai.controller.response.MotoristaResponse;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.mapper.MotoristaResponseMapper;
import br.com.cwi.crescer.melevaai.validator.CpfValidator;

@Service
public class BuscarMotoristaService {

    @Autowired
    private CpfValidator cpfValidator;

    @Autowired
    private BuscarMotoristaPorCpfService buscarMotoristaPorCpfService;

    @Autowired
    private MotoristaResponseMapper mapper;

    public MotoristaResponse buscar(String cpf) {

        cpfValidator.accept(cpf);

        Motorista motorista = buscarMotoristaPorCpfService.buscar(cpf);

        return mapper.apply(motorista);
    }
}
