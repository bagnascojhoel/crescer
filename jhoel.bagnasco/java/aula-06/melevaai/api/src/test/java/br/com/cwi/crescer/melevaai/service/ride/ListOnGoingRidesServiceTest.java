package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import br.com.cwi.crescer.melevaai.repository.RideRepository;
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
public class ListOnGoingRidesServiceTest {

    @InjectMocks
    private ListOnGoingRidesService subject;

    @Mock
    private RideRepository rideRepository;

    @Mock
    private Ride ride;

    @Test
    public void shouldBeOnGoingRidesWhenList() {
        // arrange
        Mockito.when(rideRepository.findByStatus(RideStatus.CHAMADA))
                .thenReturn(Arrays.asList(ride));

        Mockito.when(rideRepository.findByStatus(RideStatus.INICIADA))
                .thenReturn(Arrays.asList(ride));
        // act
        List<Ride> actual = subject.list();

        // assert
        Mockito.verify(rideRepository).findByStatus(RideStatus.CHAMADA);
        Mockito.verify(rideRepository).findByStatus(RideStatus.INICIADA);

        Assert.assertEquals(Arrays.asList(ride, ride), actual);
    }

}