package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import br.com.cwi.crescer.melevaai.service.driver.ListDomainDriversService;
import br.com.cwi.crescer.melevaai.validators.ride.RideAlreadyFinishedValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RideNotStartedYetValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class FinishRideService {

    @Autowired
    private FetchRideByIdService fetchRideByIdService;

    @Autowired
    private RideNotStartedYetValidator rideNotStartedYetValidator;

    @Autowired
    private RideAlreadyFinishedValidator rideAlreadyFinishedValidator;

    @Autowired
    private ListDomainRidesByCpfService listDomainRidesByCpfService;

    @Autowired
    private ListDomainDriversService listDomainDriversService;

    public void finish(String id) {
        Ride ride = fetchRideByIdService.fetch(Long.getLong(id));

        rideNotStartedYetValidator.validate(ride);

        rideAlreadyFinishedValidator.validate(ride);

        ride.setFinishDateTime(LocalDateTime.now());

        long segundos = ride.getStartDateTime().until(ride.getFinishDateTime(), ChronoUnit.SECONDS);
        ride.setRealPrice(new BigDecimal(segundos * Ride.PRICE_PER_SECOND));

        ride.makeTransactions(listDomainDriversService.list());

        ride.setStatus(RideStatus.FINALIZADA);
    }
}
