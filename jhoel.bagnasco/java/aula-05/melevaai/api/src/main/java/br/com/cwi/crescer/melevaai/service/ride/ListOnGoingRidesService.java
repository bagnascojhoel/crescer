package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Corrida;
import br.com.cwi.crescer.melevaai.domain.CorridaStatus;
import br.com.cwi.crescer.melevaai.repository.CorridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListOnGoingRidesService {

    @Autowired CorridaRepository corridaRepository;

    public List<Corrida> list() {
        List<Corrida> corridasChamadas = corridaRepository.findByStatus(CorridaStatus.CHAMADA);
        List<Corrida> corridasIniciada = corridaRepository.findByStatus(CorridaStatus.INICIADA);
        List<Corrida> result = new ArrayList<>();

        result.addAll(corridasChamadas);
        result.addAll(corridasIniciada);

        return result;

    }
}
