package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.Driver;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface DriverRepository extends Repository<Driver, Long> {

    void save(Driver driver);

    void delete(Driver driver);

    List<Driver> findAll();

    List<Driver> findByCpf(String cpf);

}
