package br.com.cwi.crescer.heranca.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.cwi.crescer.heranca.domain.PessoaFisica;

public interface PessoaFisicaRepository extends Repository<PessoaFisica, Integer> {

    PessoaFisica save(PessoaFisica pf);

    List<PessoaFisica> findAll();
}
