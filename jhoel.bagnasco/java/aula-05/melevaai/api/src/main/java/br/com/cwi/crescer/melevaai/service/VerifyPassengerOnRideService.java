package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.service.ride.ListOnGoingRidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyPassengerOnRideService {

    @Autowired
    ListOnGoingRidesService listOnGoingRidesService;

    public boolean verify(String cpf) {
        return listOnGoingRidesService.list().stream()
                .filter(c -> c.getPassageiro().getCpf().getNumero().equals(cpf))
                .findFirst()
                .isPresent();
    }
}
