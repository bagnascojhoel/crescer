package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.controller.response.StartRideResponse;
import br.com.cwi.crescer.melevaai.domain.Point;
import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import br.com.cwi.crescer.melevaai.mapper.ride.ToStartRideResponseMapper;
import br.com.cwi.crescer.melevaai.validators.ride.RideAlreadyStartedValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StartRideServiceTest {

    @InjectMocks
    private StartRideService subject;

    @Mock
    private ToStartRideResponseMapper toStartRideResponseMapper;

    @Mock
    private FetchRideByIdService fetchRideByIdService;

    @Mock
    private RideAlreadyStartedValidator rideAlreadyStartedValidator;


    @Test
    public void shouldHaveStatusIniciadaWhenStart() {
        String id = "23";
        Ride ride = Mockito.spy(new Ride());
        ride.setId(Long.getLong(id));
        ride.setStartPoint(Mockito.mock(Point.class));

        Mockito.when(fetchRideByIdService.fetch(Long.getLong(id)))
                .thenReturn(ride);
        Mockito.when(toStartRideResponseMapper.map(ride))
                .thenReturn(Mockito.mock(StartRideResponse.class));

        subject.start(id);

        Mockito.verify(fetchRideByIdService).fetch(Long.getLong(id));
        Mockito.verify(rideAlreadyStartedValidator).validate(ride);
        Mockito.verify(ride).setStartDateTime(Mockito.any());
        Mockito.verify(ride).measureExpectedPrice();
        Mockito.verify(ride).setStatus(RideStatus.INICIADA);
        Mockito.verify(toStartRideResponseMapper).map(ride);
    }
}