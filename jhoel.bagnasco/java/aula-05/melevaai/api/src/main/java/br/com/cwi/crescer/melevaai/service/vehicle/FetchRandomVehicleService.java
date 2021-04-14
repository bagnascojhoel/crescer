package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.domain.Veiculo;
import br.com.cwi.crescer.melevaai.service.vehicle.ListAvailableVehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FetchRandomVehicleService {

    @Autowired
    ListAvailableVehiclesService listAvailableVehiclesService;

    public Veiculo fetch() {
        List<Veiculo> veiculosDisponiveis = listAvailableVehiclesService.list();

        int posicaoAleatoria = new Random().nextInt(veiculosDisponiveis.size());

        return veiculosDisponiveis.get(posicaoAleatoria);
    }
}
