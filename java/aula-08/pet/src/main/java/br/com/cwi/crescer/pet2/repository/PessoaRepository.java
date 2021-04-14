package br.com.cwi.crescer.pet2.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.cwi.crescer.pet2.domain.Cor;
import br.com.cwi.crescer.pet2.domain.Pessoa;

public interface PessoaRepository extends Repository<Pessoa, Integer> {

    List<Pessoa> findAll();

    Pessoa save(Pessoa pessoa);

    List<Pessoa> findByCor(Cor cor);

    List<Pessoa> findByCorAndNome(Cor cor, String nome);
}
