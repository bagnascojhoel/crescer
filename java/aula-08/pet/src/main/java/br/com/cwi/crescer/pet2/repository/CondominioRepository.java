package br.com.cwi.crescer.pet2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import br.com.cwi.crescer.pet2.domain.Condominio;

public interface CondominioRepository extends Repository<Condominio, Integer> {

    void save(Condominio novoCondominio);

    Optional<Condominio> findByNome(String nome);

    List<Condominio> findAll();

    Condominio findById(Integer idCondominio);
}
