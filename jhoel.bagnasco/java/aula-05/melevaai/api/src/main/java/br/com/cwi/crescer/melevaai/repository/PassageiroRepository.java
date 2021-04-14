package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.CPF;
import br.com.cwi.crescer.melevaai.domain.Passageiro;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PassageiroRepository {

    public static List<Passageiro> passageiroList = new ArrayList<>();

    public List<Passageiro> findAll() {
        return passageiroList;
    }

    public void add(Passageiro passageiro) {
        passageiroList.add(passageiro);
    }

    public Optional<Passageiro> findByCpf(String cpf) {
        return passageiroList.stream()
                .filter(p -> p.getCpf().getNumero().equals(cpf))
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
