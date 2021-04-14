package br.com.cwi.crescer.heranca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import br.com.cwi.crescer.heranca.domain.Motorista;

public interface MotoristaRepository extends Repository<Motorista, Integer> {

    List<Motorista> findAll();

    Motorista save(Motorista motorista);

    Optional<Motorista> findById(Integer id);
}
