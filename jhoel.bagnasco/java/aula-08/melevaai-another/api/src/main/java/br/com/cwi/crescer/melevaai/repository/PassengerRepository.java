package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.Passenger;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PassengerRepository extends Repository<Passenger, Long> {

    void save(Passenger passenger);

    List<Passenger> findAll();

    List<Passenger> findByCpf(String cpf);

}
