package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.repository.VehicleRepository;
import br.com.cwi.crescer.melevaai.service.ride.ListOnGoingRidesService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ListAvailableDomainVehiclesServiceTest {

    @InjectMocks
    private ListAvailableDomainVehiclesService subject;

    @Mock
    private ListOnGoingRidesService listOnGoingRidesService;

    @Mock
    private VehicleRepository vehicleRepository;

    @Test
    public void shouldBeAListOfVehiclesNotOnOnGoingRideWhenList() {
        Ride ride = Mockito.mock(Ride.class);
        Vehicle vehicle = Mockito.mock(Vehicle.class);

        Mockito.when(listOnGoingRidesService.list())
                .thenReturn(Arrays.asList(ride));
        Mockito.when(vehicleRepository.findAll())
                .thenReturn(Arrays.asList(vehicle));

        subject.list();

        Mockito.verify(listOnGoingRidesService).list();
        Mockito.verify(vehicleRepository).findAll();
    }
}