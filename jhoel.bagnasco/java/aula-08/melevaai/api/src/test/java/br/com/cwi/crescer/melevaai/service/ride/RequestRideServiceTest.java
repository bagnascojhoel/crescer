package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.controller.request.RideRequest;
import br.com.cwi.crescer.melevaai.controller.response.RequestRideResponse;
import br.com.cwi.crescer.melevaai.domain.Passenger;
import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import br.com.cwi.crescer.melevaai.mapper.ride.FromRideRequestMapper;
import br.com.cwi.crescer.melevaai.mapper.ride.ToRequestRideResponseMapper;
import br.com.cwi.crescer.melevaai.repository.RideRepository;
import br.com.cwi.crescer.melevaai.service.VerifyExistsAvailableVehicleService;
import br.com.cwi.crescer.melevaai.service.VerifyPassengerIsFreeService;
import br.com.cwi.crescer.melevaai.service.passenger.FetchDomainPassengerByCpfService;
import br.com.cwi.crescer.melevaai.service.vehicle.FetchRandomAvailableVehicleService;
import br.com.cwi.crescer.melevaai.service.vehicle.ListAvailableVehiclesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RequestRideServiceTest {

    @InjectMocks
    private RequestRideService subject;

    @Mock
    private RideRepository rideRepository;

    @Mock
    private FetchDomainPassengerByCpfService fetchDomainPassengerByCpfService;

    @Mock
    private ListAvailableVehiclesService listAvailableVehiclesService;

    @Mock
    private FetchRandomAvailableVehicleService fetchRandomAvailableVehicleService;

    @Mock
    private FromRideRequestMapper fromRideRequestMapper;

    @Mock
    private ToRequestRideResponseMapper toRequestRideResponseMapper;

    @Mock
    private VerifyPassengerIsFreeService verifyPassengerIsFreeService;

    @Mock
    private VerifyExistsAvailableVehicleService verifyExistsAvailableVehicleService;

    @Test
    public void shouldValidateAndAddToRepository() {
        // arrange
        String id = "23";
        String cpf = "9";

        RideRequest rideRequest = Mockito.spy(new RideRequest());

        Ride ride = Mockito.spy(new Ride());
        RequestRideResponse requestRideResponse = Mockito.spy(new RequestRideResponse());
        requestRideResponse.setId(Long.getLong(id));


        Mockito.when(fetchDomainPassengerByCpfService.fetch(cpf))
                .thenReturn(Mockito.mock(Passenger.class));

        Mockito.when(fromRideRequestMapper.map(rideRequest))
                .thenReturn(ride);

        Mockito.when(toRequestRideResponseMapper.map(ride))
                .thenReturn(requestRideResponse);


        // act
        subject.request(cpf, rideRequest);

        // assert
        Mockito.verify(fetchDomainPassengerByCpfService).fetch(cpf);
        Mockito.verify(verifyPassengerIsFreeService).verify(cpf);
        Mockito.verify(verifyExistsAvailableVehicleService).verify();
        Mockito.verify(rideRepository).add(ride);
        Mockito.verify(toRequestRideResponseMapper).map(ride);
        Mockito.verify(ride).setStatus(RideStatus.CHAMADA);
        Mockito.verify(ride).setArrivalTime(Mockito.anyDouble());
        Mockito.verify(ride).setVehicle(Mockito.any());
    }
}