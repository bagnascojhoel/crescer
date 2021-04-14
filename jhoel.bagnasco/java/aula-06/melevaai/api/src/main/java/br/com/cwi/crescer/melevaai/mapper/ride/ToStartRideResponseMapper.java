package br.com.cwi.crescer.melevaai.mapper.ride;

import br.com.cwi.crescer.melevaai.controller.response.StartRideResponse;
import br.com.cwi.crescer.melevaai.domain.Ride;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ToStartRideResponseMapper {

    @Autowired
    private ModelMapper mapper;

    public StartRideResponse map(Ride ride) {
        StartRideResponse result = mapper.map(ride, StartRideResponse.class);
        result.setExpectedArrivalDateTime(LocalDateTime.now().plusSeconds(Math.round(ride.getExpectedTime())));

        return result;
    }
}
