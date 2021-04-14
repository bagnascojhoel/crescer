package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.Ride;
import br.com.cwi.crescer.melevaai.domain.RideStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RideRepository {

    private static final int ADD_TO_NEXT_ID = 1;

    public static List<Ride> rideList = new ArrayList<>();

    public List<Ride> findAll() {
        return rideList;
    }

    public void add(Ride ride) {
        Long nextId = new Long(rideList.size() + ADD_TO_NEXT_ID);
        ride.setId(nextId);
        rideList.add(ride);
    }

    public List<Ride> findByStatus(RideStatus status) {
        return rideList.stream()
                .filter(c -> c.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public Optional<Ride> findById(Long id) {
        return rideList.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

//    public static List<Ride> getMockCorridas() {
//        List<Ride> result = new ArrayList<>();
//
//        Ride corrida1 = new Ride(
//                1,
//                PassageiroController.getMockPassageiros().get(0),
//                VeiculoController.getMockVeiculos().get(0),
//                new Ponto(159, 234),
//                new Ponto(0, 0),
//                Ride.calcularTempoChegadaEstimado(),
//                LocalDateTime.now(),
//                LocalDateTime.now().plusSeconds(Ride.calcularTempoChegadaEstimado()),
//                15,
//                Ride.calcularTempoChegadaEstimado(),
//                12,
//                StatusCorrida.FINALIZADA,
//                4,
//                5
//        );
//
//        Ride corrida2 = new Ride(
//                2,
//                PassageiroController.getMockPassageiros().get(0),
//                VeiculoController.getMockVeiculos().get(1),
//                new Ponto(159, 234),
//                new Ponto(0, 0),
//                Ride.calcularTempoChegadaEstimado(),
//                LocalDateTime.now(),
//                LocalDateTime.now().plusSeconds(Ride.calcularTempoChegadaEstimado()),
//                53,
//                Ride.calcularTempoChegadaEstimado(),
//                3,
//                StatusCorrida.FINALIZADA,
//                1,
//                1
//        );
//
//        Ride corrida3 = new Ride(
//                3,
//                PassageiroController.getMockPassageiros().get(1),
//                VeiculoController.getMockVeiculos().get(2),
//                new Ponto(159, 234),
//                new Ponto(0, 0),
//                Ride.calcularTempoChegadaEstimado(),
//                LocalDateTime.now(),
//                LocalDateTime.now().plusSeconds(Ride.calcularTempoChegadaEstimado()),
//                98,
//                Ride.calcularTempoChegadaEstimado(),
//                99,
//                StatusCorrida.FINALIZADA,
//                5,
//                1
//        );
//
//        Ride corrida4 = new Ride(
//                4,
//                PassageiroController.getMockPassageiros().get(2),
//                VeiculoController.getMockVeiculos().get(2),
//                new Ponto(159, 234),
//                new Ponto(0, 0),
//                Ride.calcularTempoChegadaEstimado(),
//                LocalDateTime.now(),
//                LocalDateTime.now().plusSeconds(Ride.calcularTempoChegadaEstimado()),
//                1,
//                Ride.calcularTempoChegadaEstimado(),
//                12,
//                StatusCorrida.FINALIZADA,
//                1,
//                5
//        );
//
//        result.add(corrida1);
//        result.add(corrida2);
//        result.add(corrida3);
//        result.add(corrida4);
//
//        return result;
//    }
}
