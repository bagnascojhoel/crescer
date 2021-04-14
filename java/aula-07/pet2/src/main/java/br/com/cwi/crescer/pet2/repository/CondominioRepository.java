package br.com.cwi.crescer.pet2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.pet2.domain.Condominio;

@Repository
public class CondominioRepository {

    public static final List<Condominio> LISTA = new ArrayList<Condominio>();

    public void save(Condominio novoCondominio) {

        // gerei identificador
        int id = LISTA.size() + 1;
        novoCondominio.setId(id);

        // persistindo/incluindo na lista
        LISTA.add(novoCondominio);
    }

    public Optional<Condominio> findByNome(String nome) {
        return LISTA.stream()
            .filter(c -> c.getNome().equals(nome))
            .findFirst();
    }
}
