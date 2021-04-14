package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PassengerRepository {

    public static List<Passenger> passengerList = new ArrayList<>();

    public List<Passenger> findAll() {
        return passengerList;
    }

    public void add(Passenger passenger) {
        passengerList.add(passenger);
    }

    public Optional<Passenger> findByCpf(String cpf) {
        return passengerList.stream()
                .filter(p -> p.getCpf().equals(cpf))
                .findFirst();
    }

//    public static List<Passageiro> getMockPassageiros() {
//        List<Passageiro> result = new ArrayList<>();
//
//        Passageiro passageiro1 = new Passageiro(
//                "Kent Beck",
//                "beck@xp.com",
//                LocalDate.parse("1961-03-31"),
//                new CPF("96475818070"),
//                300,
//                4.3
//        );
//
//        Passageiro passageiro2 = new Passageiro(
//                "Robert Cecil Martin",
//                "martin@cleancoder.com",
//                LocalDate.parse("1952-03-31"),
//                new CPF("09125251007"),
//                0,
//                1
//        );
//
//        Passageiro passageiro3 = new Passageiro(
//                "Frederick P. Brooks Jr.",
//                "fredinho@manmonth.net",
//                LocalDate.parse("1931-04-19"),
//                new CPF("27100629098"),
//                5,
//                5
//        );
//
//        result.add(passageiro1);
//        result.add(passageiro2);
//        result.add(passageiro3);
//
//        return result;
//    }

}
