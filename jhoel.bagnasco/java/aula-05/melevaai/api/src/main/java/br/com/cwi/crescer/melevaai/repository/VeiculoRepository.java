package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.controller.MotoristaController;
import br.com.cwi.crescer.melevaai.domain.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VeiculoRepository {

    public static List<Veiculo> veiculos = new ArrayList<>();

    public List<Veiculo> findAll() {
        return veiculos;
    }

    public void add(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public Optional<Veiculo> findByOwnerCpf(String cpf) {
        return veiculos.stream()
                .filter(v -> v.getProprietario().getCpf().getNumero().equals(cpf))
                .findFirst();

    }

//    public static List<Veiculo> getMockVeiculos() {
//        List<Veiculo> result = new ArrayList<>();
//        Veiculo veiculo1 = new Veiculo(
//                new Placa("RIO2A18"),
//                Marca.AUDI,
//                "SUV",
//                2021,
//                Cor.PRETO,
//                new URL("https://www.minimundi.com.br/cdn/imagens/produtos/det/miniatura-carro-audi-r8-gt-premiere-edition-1-18-maisto-36190-011036_a.jpg"),
//                Categoria.A,
//                2,
//                MotoristaController.getMockMotorista().get(0)
//        );
//
//        Veiculo veiculo2 = new Veiculo(
//                new Placa("LSU3J43"),
//                Marca.JAC,
//                "Esportivo",
//                1800,
//                Cor.BRANCO,
//                new URL("https://www.planetcarsz.com/assets/uploads/4b1809e1c46f81e737e0e8b542f25f5d.jpg"),
//                Categoria.E,
//                5,
//                MotoristaController.getMockMotorista().get(1)
//        );
//
//        Veiculo veiculo3 = new Veiculo(
//                new Placa("EMP0A14"),
//                Marca.MERCEDES_BENZ,
//                "Coletivo",
//                1986,
//                Cor.PRATA,
//                new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSo2gCO3SZ6rS81mGFie90QG93knW1CzGzuUQ&usqp=CAU"),
//                Categoria.ACC,
//                999,
//                MotoristaController.getMockMotorista().get(2)
//        );
//
//        result.add(veiculo1);
//        result.add(veiculo2);
//        result.add(veiculo3);
//
//        return result;
//    }
}
