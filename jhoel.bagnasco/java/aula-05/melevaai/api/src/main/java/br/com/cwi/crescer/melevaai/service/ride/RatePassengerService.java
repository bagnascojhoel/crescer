package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Corrida;
import br.com.cwi.crescer.melevaai.validators.ride.RideOnGoingValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RidePassengerScoreValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RideScoreValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatePassengerService {

    @Autowired FetchRideByIdService fetchRideByIdService;

    @Autowired
    RideScoreValidator rideScoreValidator;

    @Autowired
    RidePassengerScoreValidator ridePassengerScoreValidator;

    @Autowired
    RideOnGoingValidator rideOnGoingValidator;

    public void rate(String idCorrida, String nota) {

        Corrida ride = fetchRideByIdService.fetch(Integer.parseInt(idCorrida));

        rideScoreValidator.validate(Integer.parseInt(nota));

        ridePassengerScoreValidator.validate(ride);

        rideOnGoingValidator.validate(ride);

        ride.setNotaParaPassageiro(Integer.parseInt(nota));
        ride.getPassageiro().calcularMedia();
    }
}
