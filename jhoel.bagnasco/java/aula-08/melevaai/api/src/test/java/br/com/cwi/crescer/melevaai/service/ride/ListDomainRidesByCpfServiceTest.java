package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.repository.RideRepository;
import br.com.cwi.crescer.melevaai.service.driver.ListDomainDriversService;
import br.com.cwi.crescer.melevaai.service.passenger.FetchDomainPassengerByCpfService;
import br.com.cwi.crescer.melevaai.service.passenger.FetchPassengerByCpfService;
import br.com.cwi.crescer.melevaai.validators.ride.RideWithPassengerExistsValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ListDomainRidesByCpfServiceTest {

    @InjectMocks
    private ListDomainRidesByCpfService subject;

    @Mock
    private FetchDomainPassengerByCpfService fetchDomainPassengerByCpfService;

    @Mock
    private RideWithPassengerExistsValidator rideWithPassengerExistsValidator;

    @Mock
    private RideRepository rideRepository;

    @Test
    public void shouldBeListWithFirstRideWithCorrectIdWhenList() {
        // arrange
        String cpf = "6";
        Ride ride = new Ride();
        Passenger passenger = new Passenger();
        passenger.setCpf(cpf);

        ride.setPassenger(passenger);

        Mockito.when(rideRepository.findAll())
                .thenReturn(Arrays.asList(ride));

        Mockito.when(fetchDomainPassengerByCpfService.fetch(cpf))
                .thenReturn(passenger);

        // act
        subject.list(cpf);

        // assert
        Mockito.verify(rideRepository).findAll();
        Mockito.verify(fetchDomainPassengerByCpfService).fetch(cpf);
        Mockito.verify(rideWithPassengerExistsValidator).validate(Arrays.asList(ride));
    }
}