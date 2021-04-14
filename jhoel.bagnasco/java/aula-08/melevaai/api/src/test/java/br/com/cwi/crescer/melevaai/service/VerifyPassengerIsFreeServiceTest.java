package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.service.ride.ListOnGoingRidesService;
import br.com.cwi.crescer.melevaai.validators.ride.RideWithFreePassengerValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
public class VerifyPassengerIsFreeServiceTest {

    @InjectMocks
    private VerifyPassengerIsFreeService subject;

    @Mock
    private ListOnGoingRidesService listOnGoingRidesService;

    @Mock
    private RideWithFreePassengerValidator rideWithFreePassengerValidator;

    @Test
    public void shouldValidateIfRideIsWithFreePassengerWhenVerify() {
        String cpf = "234";
        Ride ride = new Ride();
        Passenger passenger = new Passenger();
        passenger.setCpf(cpf);

        ride.setPassenger(passenger);

        Mockito.when(listOnGoingRidesService.list())
                .thenReturn(Arrays.asList(ride));

        subject.verify(cpf);

        Mockito.verify(listOnGoingRidesService).list();
        Mockito.verify(rideWithFreePassengerValidator).validate(Optional.of(ride));
    }
}