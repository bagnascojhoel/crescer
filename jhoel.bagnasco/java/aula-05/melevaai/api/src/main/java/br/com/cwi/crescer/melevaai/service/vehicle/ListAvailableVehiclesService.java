package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.domain.Veiculo;
import br.com.cwi.crescer.melevaai.repository.VeiculoRepository;
import br.com.cwi.crescer.melevaai.service.ride.ListOnGoingRidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListAvailableVehiclesService {

    @Autowired ListOnGoingRidesService listOnGoingRidesService;

    @Autowired VeiculoRepository veiculoRepository;

    public List<Veiculo> list() {
        List<Veiculo> veiculosOcupados = listOnGoingRidesService.list().stream()
                .map(c -> c.getVeiculo())
                .distinct()
                .collect(Collectors.toList());

        return veiculoRepository.findAll().stream()
                .filter(v -> !veiculosOcupados.contains(v))
                .collect(Collectors.toList());
    }
}
