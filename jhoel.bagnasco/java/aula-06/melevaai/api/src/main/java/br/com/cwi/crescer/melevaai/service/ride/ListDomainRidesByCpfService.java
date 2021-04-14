package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import br.com.cwi.crescer.melevaai.repository.RideRepository;
import br.com.cwi.crescer.melevaai.service.passenger.FetchDomainPassengerByCpfService;
import br.com.cwi.crescer.melevaai.service.passenger.FetchPassengerByCpfService;
import br.com.cwi.crescer.melevaai.validators.ride.RideWithPassengerExistsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListDomainRidesByCpfService {

    @Autowired
    private FetchDomainPassengerByCpfService fetchDomainPassengerByCpfService;

    @Autowired
    private RideWithPassengerExistsValidator rideWithPassengerExistsValidator;

    @Autowired
    private RideRepository rideRepository;

    public List<Ride> list(String cpf) {

        List<Ride> rides = rideRepository.findAll()
                .stream()
                .filter(c -> c.getPassenger().equals(fetchDomainPassengerByCpfService.fetch(cpf)))
                .collect(Collectors.toList());

        rideWithPassengerExistsValidator.validate(rides);

        return rides;
    }

}
