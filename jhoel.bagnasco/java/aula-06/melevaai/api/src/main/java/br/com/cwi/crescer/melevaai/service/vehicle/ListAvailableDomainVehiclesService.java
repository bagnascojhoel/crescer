package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.repository.VehicleRepository;
import br.com.cwi.crescer.melevaai.service.ride.ListOnGoingRidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListAvailableDomainVehiclesService {

    @Autowired
    private ListOnGoingRidesService listOnGoingRidesService;

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> list() {
        List<Vehicle> vehiclesOcupados = listOnGoingRidesService.list().stream()
                .map(c -> c.getVehicle())
                .distinct()
                .collect(Collectors.toList());

        return vehicleRepository.findAll().stream()
                .filter(v -> !vehiclesOcupados.contains(v))
                .collect(Collectors.toList());
    }
}
