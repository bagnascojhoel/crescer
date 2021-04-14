package br.com.cwi.crescer.melevaai.service.passenger;

import br.com.cwi.crescer.melevaai.controller.response.PassageiroResponse;
import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.repository.PassageiroRepository;
import br.com.cwi.crescer.melevaai.validators.passenger.PassengerDoesNotExistValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FetchPassengerByCpfService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PassageiroRepository passageiroRepository;

    @Autowired
    PassengerDoesNotExistValidator passengerDoesNotExistValidator;

    public PassageiroResponse fetch(String cpf) {
        Optional<Passageiro> optionalPassageiro = passageiroRepository.findByCpf(cpf);

        passengerDoesNotExistValidator.validate(optionalPassageiro);

        return modelMapper.map(optionalPassageiro.get(), PassageiroResponse.class);
    }
}
