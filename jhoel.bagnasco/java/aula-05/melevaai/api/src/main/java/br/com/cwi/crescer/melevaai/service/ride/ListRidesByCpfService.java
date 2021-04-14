package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Corrida;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.repository.CorridaRepository;
import br.com.cwi.crescer.melevaai.service.passenger.FetchPassengerByCpfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListRidesByCpfService {

    @Autowired
    FetchPassengerByCpfService fetchPassengerByCpfService;

    @Autowired
    CorridaRepository corridaRepository;

    public List<Corrida> list(String cpf) {

        List<Corrida> corridas = corridaRepository.findAll()
                .stream()
                .filter(c -> c.getPassageiro().equals(fetchPassengerByCpfService.fetch(cpf)))
                .collect(Collectors.toList());

        if(corridas.size() <= 0)
            throw new ValidacaoNegocioException("Passageiro não possui nenhum registro de corrida.");

        return corridas;
    }

}
