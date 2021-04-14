package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.domain.Veiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class VeiculoRepository {

    private static List<Veiculo> veiculos = new ArrayList<>();

    public Optional<Veiculo> findByMotorista(Motorista motorista) {

        return veiculos
            .stream()
            .filter(e -> e.getProprietario().equals(motorista))
            .findFirst();
    }
}
