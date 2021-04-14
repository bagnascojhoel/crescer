package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.CNH;
import br.com.cwi.crescer.melevaai.domain.CPF;
import br.com.cwi.crescer.melevaai.domain.Categoria;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MotoristaRepository {

    public static List<Motorista> motoristas = new ArrayList<>();

    public List<Motorista> findAll() {
        return motoristas;
    }

    public Optional<Motorista> findByCpf(String cpf) {
        return motoristas.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst();
    }

    public void add(Motorista motorista) {
        motoristas.add(motorista);
    }

    public void remove(Motorista motorista) {
        motoristas.remove(motorista);
    }

//    public static List<Motorista> getMockMotorista() {
//        List<Motorista> result = new ArrayList<>();
//        Motorista motorista1 = new Motorista(
//                "Jonas",
//                "jonas.fonseca@gmail.com",
//                LocalDate.parse("2000-12-12"),
//                new CPF("63369321092"),
//                15.00,
//                4.7,
//                new CNH(
//                        "123456789",
//                        Categoria.A,
//                        LocalDate.parse("2050-12-12")
//                )
//        );
//
//        Motorista motorista2 = new Motorista(
//                "Eric Evans",
//                "evans@ddd.com",
//                LocalDate.parse("1999-02-20"),
//                new CPF("23845868074"),
//                1000,
//                2.5,
//                new CNH(
//                        "987654321",
//                        Categoria.E,
//                        LocalDate.parse("2020-12-12")
//                )
//        );
//
//        Motorista motorista3 = new Motorista(
//                "Martin Fowler",
//                "martin999@gmail.com",
//                LocalDate.parse("1963-12-18"),
//                new CPF("34434858041"),
//                0,
//                5,
//                new CNH(
//                        "234567891",
//                        Categoria.ACC,
//                        LocalDate.parse("2100-05-05")
//                )
//        );
//
//        result.add(motorista1);
//        result.add(motorista2);
//        result.add(motorista3);
//
//        return result;
//    }
}
