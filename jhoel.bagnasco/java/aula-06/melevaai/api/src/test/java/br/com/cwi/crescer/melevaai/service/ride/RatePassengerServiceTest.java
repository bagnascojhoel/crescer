package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.validators.ride.RideNotFinishedYetValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RidePassengerScoreValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RideScoreValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RatePassengerServiceTest {

    @InjectMocks
    private RatePassengerService subject;

    @Mock
    private FetchRideByIdService fetchRideByIdService;

    @Mock
    private RideScoreValidator rideScoreValidator;

    @Mock
    private RidePassengerScoreValidator ridePassengerScoreValidator;

    @Mock
    private RideNotFinishedYetValidator rideNotFinishedYetValidator;

    @Mock
    private ListDomainRidesByCpfService listDomainRidesByCpfService;

    @Test
    public void shouldMakeValidationsSetPassengerScoreAndUpdateAverageScoreWhenRate() {
        // arrange
        String cpf = "7";
        String id = "6";
        String score = "5";

        Ride ride = Mockito.spy(new Ride());
        Passenger passenger = Mockito.spy(new Passenger());
        ride.setPassenger(passenger);

        Mockito.when(passenger.getCpf()).thenReturn(cpf);

        Mockito.when(fetchRideByIdService.fetch(Long.getLong(id)))
                .thenReturn(ride);

        Mockito.when(listDomainRidesByCpfService.list(cpf))
                .thenReturn(Arrays.asList());

        // act
        subject.rate(id, score);

        // assert
        Mockito.verify(fetchRideByIdService).fetch(Long.getLong(id));
        Mockito.verify(rideScoreValidator).validate(Integer.parseInt(score));
        Mockito.verify(ridePassengerScoreValidator).validate(ride);
        Mockito.verify(rideNotFinishedYetValidator).validate(ride);
        Mockito.verify(ride).setPassengerScore(Integer.parseInt(score));
        Mockito.verify(passenger).measureAvgScore(Arrays.asList());
    }
}