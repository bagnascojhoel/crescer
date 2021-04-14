package br.com.cwi.crescer.pet2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.pet2.controller.request.IncluirCondominioRequest;
import br.com.cwi.crescer.pet2.domain.Condominio;
import br.com.cwi.crescer.pet2.exception.NegocioException;
import br.com.cwi.crescer.pet2.repository.CondominioRepository;

@Service
public class ValidarCondominioDuplicadoService {

    @Autowired
    private CondominioRepository condominioRepository;

    public void accept(IncluirCondominioRequest request) {

        // Validação complexa (tem dependência - LISTA - além do request)
        Optional<Condominio> condominioDuplicado =
            condominioRepository.findByNome(request.getNome());

        if (condominioDuplicado.isPresent()) {
            throw new NegocioException("Já existe um condomínio com este nome");
        }
    }
}
