package br.com.cwi.crescer.heranca.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.cwi.crescer.heranca.domain.Motorista;

public interface MotoristaRepository extends PagingAndSortingRepository<Motorista, Integer> {

    Page<Motorista> findAll(Pageable pageable);
}
