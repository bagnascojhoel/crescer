package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.validators.ride.RideDriverScoreValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RideNotFinishedYetValidator;
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
public class RateDriverServiceTest {

    @InjectMocks
    private RateDriverService subject;

    @Mock
    private FetchRideByIdService fetchRideByIdService;

    @Mock
    private RideScoreValidator rideScoreValidator;

    @Mock
    private RideDriverScoreValidator rideDriverScoreValidator;

    @Mock
    private RideNotFinishedYetValidator rideNotFinishedYetValidator;

    @Mock
    private ListDomainRidesByCpfService listDomainRidesByCpfService;

    @Test
    public void shouldValidateAndSetDriverScoreWhenRate() {
        // arrange
        String id = "78";
        String score = "3";
        String cpf = "6";

        Ride ride = Mockito.spy(new Ride());
        Vehicle vehicle = Mockito.spy(new Vehicle());
        Driver driver = Mockito.spy(new Driver());
        vehicle.setOwner(driver);
        ride.setId(Long.getLong(id));
        ride.setVehicle(vehicle);

        Mockito.when(fetchRideByIdService.fetch(Long.getLong(score)))
                .thenReturn(ride);

        Mockito.when(ride.getVehicle()).thenReturn(vehicle);

        Mockito.when(vehicle.getOwner()).thenReturn(driver);

        Mockito.when(driver.getCpf()).thenReturn(cpf);

        Mockito.when(listDomainRidesByCpfService.list(cpf))
                .thenReturn(Arrays.asList(ride));

        // act
        subject.rate(id, score);

        // assert
        Mockito.verify(fetchRideByIdService).fetch(Long.getLong(id));
        Mockito.verify(rideScoreValidator).validate(Integer.parseInt(score));
        Mockito.verify(rideDriverScoreValidator).validate(ride);
        Mockito.verify(rideNotFinishedYetValidator).validate(ride);
        Mockito.verify(listDomainRidesByCpfService).list(cpf);
    }
}