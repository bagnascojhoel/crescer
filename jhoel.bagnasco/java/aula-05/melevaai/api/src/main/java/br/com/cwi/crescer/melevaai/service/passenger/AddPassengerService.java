package br.com.cwi.crescer.melevaai.service.passenger;

import br.com.cwi.crescer.melevaai.controller.request.PassageiroRequest;
import br.com.cwi.crescer.melevaai.controller.response.PassageiroResponse;
import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.repository.PassageiroRepository;
import br.com.cwi.crescer.melevaai.validators.PersonCpfValidator;
import br.com.cwi.crescer.melevaai.validators.passenger.PassengerAgeValidator;
import br.com.cwi.crescer.melevaai.validators.passenger.PassengerExistsValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddPassengerService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    PassageiroRepository passageiroRepository;

    @Autowired
    PersonCpfValidator personCpfValidator;

    @Autowired
    PassengerExistsValidator passengerExistsValidator;

    @Autowired
    PassengerAgeValidator passengerAgeValidator;

    public PassageiroResponse add(PassageiroRequest passageiroRequest) {

        Passageiro passageiro = mapper.map(passageiroRequest, Passageiro.class);

        passengerExistsValidator.validate(passageiroRepository.findByCpf(passageiro.getCpf().getNumero()));

        passengerAgeValidator.validate(passageiro.getIdade());

        personCpfValidator.validate(passageiro.getCpf().getNumero());

        passageiroRepository.add(passageiro);

        PassageiroResponse response = mapper.map(passageiro, PassageiroResponse.class);

        return response;
    }
}
