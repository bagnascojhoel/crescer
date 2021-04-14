package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.Corrida;
import br.com.cwi.crescer.melevaai.domain.CorridaStatus;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CorridaRepository {

    public static List<Corrida> corridaList = new ArrayList<>();

    public List<Corrida> findAll() {
        return corridaList;
    }

    public void add(Corrida corrida) {
        corridaList.add(corrida);
    }

    public List<Corrida> findByStatus(CorridaStatus status) {
        return corridaList.stream()
                .filter(c -> c.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public Optional<Corrida> findById(int id) {
        return corridaList.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

//    public static List<Corrida> getMockCorridas() {
//        List<Corrida> result = new ArrayList<>();
//
//        Corrida corrida1 = new Corrida(
//                1,
//                PassageiroController.getMockPassageiros().get(0),
//                VeiculoController.getMockVeiculos().get(0),
//                new Ponto(159, 234),
//                new Ponto(0, 0),
//                Corrida.calcularTempoChegadaEstimado(),
//                LocalDateTime.now(),
//                LocalDateTime.now().plusSeconds(Corrida.calcularTempoChegadaEstimado()),
//                15,
//                Corrida.calcularTempoChegadaEstimado(),
//                12,
//                StatusCorrida.FINALIZADA,
//                4,
//                5
//        );
//
//        Corrida corrida2 = new Corrida(
//                2,
//                PassageiroController.getMockPassageiros().get(0),
//                VeiculoController.getMockVeiculos().get(1),
//                new Ponto(159, 234),
//                new Ponto(0, 0),
//                Corrida.calcularTempoChegadaEstimado(),
//                LocalDateTime.now(),
//                LocalDateTime.now().plusSeconds(Corrida.calcularTempoChegadaEstimado()),
//                53,
//                Corrida.calcularTempoChegadaEstimado(),
//                3,
//                StatusCorrida.FINALIZADA,
//                1,
//                1
//        );
//
//        Corrida corrida3 = new Corrida(
//                3,
//                PassageiroController.getMockPassageiros().get(1),
//                VeiculoController.getMockVeiculos().get(2),
//                new Ponto(159, 234),
//                new Ponto(0, 0),
//                Corrida.calcularTempoChegadaEstimado(),
//                LocalDateTime.now(),
//                LocalDateTime.now().plusSeconds(Corrida.calcularTempoChegadaEstimado()),
//                98,
//                Corrida.calcularTempoChegadaEstimado(),
//                99,
//                StatusCorrida.FINALIZADA,
//                5,
//                1
//        );
//
//        Corrida corrida4 = new Corrida(
//                4,
//                PassageiroController.getMockPassageiros().get(2),
//                VeiculoController.getMockVeiculos().get(2),
//                new Ponto(159, 234),
//                new Ponto(0, 0),
//                Corrida.calcularTempoChegadaEstimado(),
//                LocalDateTime.now(),
//                LocalDateTime.now().plusSeconds(Corrida.calcularTempoChegadaEstimado()),
//                1,
//                Corrida.calcularTempoChegadaEstimado(),
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
