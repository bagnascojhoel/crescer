package br.com.cwi.crescer.heranca.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.cwi.crescer.heranca.domain.PessoaJuridica;

public interface PessoaJuridicaRepository extends Repository<PessoaJuridica, Integer> {

    PessoaJuridica save(PessoaJuridica pf);

    List<PessoaJuridica> findAll();
}
