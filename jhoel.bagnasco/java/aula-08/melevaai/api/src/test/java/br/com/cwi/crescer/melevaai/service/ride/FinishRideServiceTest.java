package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.*;
import br.com.cwi.crescer.melevaai.service.driver.ListDomainDriversService;
import br.com.cwi.crescer.melevaai.validators.ride.RideAlreadyFinishedValidator;
import br.com.cwi.crescer.melevaai.validators.ride.RideNotStartedYetValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FinishRideServiceTest {

    @InjectMocks
    private FinishRideService subject;

    @Mock
    private FetchRideByIdService fetchRideByIdService;

    @Mock
    private RideNotStartedYetValidator rideNotStartedYetValidator;

    @Mock
    private RideAlreadyFinishedValidator rideAlreadyFinishedValidator;

    @Mock
    private ListDomainRidesByCpfService listDomainRidesByCpfService;

    @Mock
    private ListDomainDriversService listDomainDriversService;

    @Mock
    private Driver driver;

    @Test
    public void shouldMakeTransactionsWhenFinish() {
        // arrange
        String id = "7";
        Ride ride = Mockito.spy(new Ride());
        ride.setId(Long.getLong(id));
        ride.setPassenger(Mockito.mock(Passenger.class));
        ride.setVehicle(Mockito.mock(Vehicle.class));

        Mockito.when(fetchRideByIdService.fetch(Long.getLong(id)))
                .thenReturn(ride);

        Mockito.when(ride.getStartDateTime())
                .thenReturn(LocalDateTime.now());

        Mockito.when(listDomainDriversService.list())
                .thenReturn(Arrays.asList(driver));
        // act
        subject.finish(id);

        // assert
        Mockito.verify(fetchRideByIdService).fetch(Long.getLong(id));
        Mockito.verify(rideNotStartedYetValidator).validate(ride);
        Mockito.verify(rideAlreadyFinishedValidator).validate(ride);
        Mockito.verify(ride).setFinishDateTime(Mockito.any());
        Mockito.verify(ride).setRealPrice(Mockito.any());
        Mockito.verify(ride).makeTransactions(Arrays.asList(driver));
        Mockito.verify(ride).setStatus(RideStatus.FINALIZADA);

    }
}