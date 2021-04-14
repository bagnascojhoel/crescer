package br.com.cwi.crescer.melevaai.mapper.ride;

import br.com.cwi.crescer.melevaai.controller.response.RequestRideResponse;
import br.com.cwi.crescer.melevaai.domain.Ride;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToRequestRideResponseMapper {

    @Autowired
    private ModelMapper mapper;

    public RequestRideResponse map(Ride ride) {
        return mapper.map(ride, RequestRideResponse.class);
    }
}
