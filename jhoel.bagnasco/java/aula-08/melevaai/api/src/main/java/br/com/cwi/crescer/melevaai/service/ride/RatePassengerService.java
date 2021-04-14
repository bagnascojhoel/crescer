package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.validators.ride.RideNotFinishedYetValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RidePassengerScoreValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RideScoreValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatePassengerService {

    @Autowired
    private FetchRideByIdService fetchRideByIdService;

    @Autowired
    private RideScoreValidator rideScoreValidator;

    @Autowired
    private RidePassengerScoreValidator ridePassengerScoreValidator;

    @Autowired
    private RideNotFinishedYetValidator rideNotFinishedYetValidator;

    @Autowired
    private ListDomainRidesByCpfService listDomainRidesByCpfService;

    public void rate(String idCorrida, String nota) {

        Ride ride = fetchRideByIdService.fetch(Long.getLong(idCorrida));

        rideScoreValidator.validate(Integer.parseInt(nota));

        ridePassengerScoreValidator.validate(ride);

        rideNotFinishedYetValidator.validate(ride);

        ride.setPassengerScore(Integer.parseInt(nota));
        ride.getPassenger().measureAvgScore(listDomainRidesByCpfService.list(ride.getPassenger().getCpf()));
    }
}
