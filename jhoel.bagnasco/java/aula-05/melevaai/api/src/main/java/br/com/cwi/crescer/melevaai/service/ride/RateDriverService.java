package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Corrida;
import br.com.cwi.crescer.melevaai.validators.ride.RideOnGoingValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RideDriverScoreValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RideScoreValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateDriverService {

    @Autowired FetchRideByIdService fetchRideByIdService;

    @Autowired
    RideScoreValidator rideScoreValidator;

    @Autowired RideDriverScoreValidator rideDriverScoreValidator;

    @Autowired
    RideOnGoingValidator rideOnGoingValidator;

    public void rate(String rideId, String score) {
        Corrida ride = fetchRideByIdService.fetch(Integer.parseInt(rideId));

        rideScoreValidator.validate(Integer.parseInt(score));

        rideDriverScoreValidator.validate(ride);

        rideOnGoingValidator.validate(ride);

        ride.setNotaParaMotorista(Integer.parseInt(score));

        ride.getVeiculo().getProprietario().calcularMedia();
    }
}
