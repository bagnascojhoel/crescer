package br.com.cwi.crescer.heranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cwi.crescer.heranca.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    Pessoa findByCpf(String cpf);
}
