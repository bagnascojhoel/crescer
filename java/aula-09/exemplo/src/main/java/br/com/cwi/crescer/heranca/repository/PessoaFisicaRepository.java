package br.com.cwi.crescer.heranca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import br.com.cwi.crescer.heranca.domain.PessoaFisica;
import br.com.cwi.crescer.heranca.domain.dto.PassageiroSaldoQualquerCoisa;

public interface PessoaFisicaRepository extends Repository<PessoaFisica, Integer> {

    PessoaFisica save(PessoaFisica pf);

    List<PessoaFisica> findAll();

    // 1º - buscar com os métodos do repositório
    PessoaFisica findByCpf(String cpf);

    // 2º - JPQL - Parece SQL mas utiliza os dados/nomes da classe java
    @Query(value = "SELECT p FROM PessoaFisica p WHERE p.cpf = ?1 LIMIT ?2")
    PessoaFisica findByCpfBananaJPQL(String cpf, Integer limit);

    // 3º - SQL Nativo
    @Query(value = "SELECT * FROM a_pessoa_fisica p WHERE p.meu_cpf_novo = ?1 FETCH FIRST ?2 ROWS ONLY"
        , nativeQuery = true)
    PessoaFisica findByCpfBananaSQLNATIVO(String cpf, Integer limit);







    @Query("SELECT new br.com.cwi.crescer.heranca.domain.dto.PassageiroSaldoQualquerCoisa(p.nome, p.saldo) FROM Passageiro p")
    List<PassageiroSaldoQualquerCoisa> montarRelatorioCusto();















}
