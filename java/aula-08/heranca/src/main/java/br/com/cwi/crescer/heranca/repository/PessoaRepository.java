package br.com.cwi.crescer.heranca.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.cwi.crescer.heranca.domain.Pessoa;

public interface PessoaRepository extends Repository<Pessoa, Integer> {

    List<Pessoa> findAll();
}
