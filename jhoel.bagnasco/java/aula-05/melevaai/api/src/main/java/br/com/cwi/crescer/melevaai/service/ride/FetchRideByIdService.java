package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Corrida;
import br.com.cwi.crescer.melevaai.exception.RegistroNaoEncontratoException;
import br.com.cwi.crescer.melevaai.repository.CorridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FetchRideByIdService {
    @Autowired CorridaRepository corridaRepository;

    public Corrida fetch(int id) {
        Optional<Corrida> corrida = corridaRepository.findById(id);

        if (!corrida.isPresent())
            throw new RegistroNaoEncontratoException("Corrida não encontrada.");

        return corrida.get();
    }
}
