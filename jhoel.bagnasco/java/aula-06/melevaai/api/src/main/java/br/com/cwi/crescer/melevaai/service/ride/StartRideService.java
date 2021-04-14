package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.controller.response.StartRideResponse;
import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import br.com.cwi.crescer.melevaai.mapper.ride.ToStartRideResponseMapper;
import br.com.cwi.crescer.melevaai.validators.ride.RideAlreadyStartedValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StartRideService {

    @Autowired
    private ToStartRideResponseMapper toStartRideResponseMapper;

    @Autowired
    private FetchRideByIdService fetchRideByIdService;

    @Autowired
    private RideAlreadyStartedValidator rideAlreadyStartedValidator;


    public StartRideResponse start(String id) {

        Ride ride = fetchRideByIdService.fetch(Long.getLong(id));

        rideAlreadyStartedValidator.validate(ride);

        mapStartRide(ride);

        return toStartRideResponseMapper.map(ride);
    }

    private Ride mapStartRide(Ride ride) {
        ride.setStartDateTime(LocalDateTime.now());
        ride.measureExpectedPrice();
        ride.setStatus(RideStatus.INICIADA);

        return ride;
    }
}
