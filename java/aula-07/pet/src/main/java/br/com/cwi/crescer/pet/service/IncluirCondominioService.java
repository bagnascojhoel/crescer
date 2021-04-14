package br.com.cwi.crescer.pet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.cwi.crescer.pet.controller.CondominioController;
import br.com.cwi.crescer.pet.controller.request.IncluirCondominioRequest;
import br.com.cwi.crescer.pet.controller.response.IncluirCondominioResponse;
import br.com.cwi.crescer.pet.domain.Condominio;
import br.com.cwi.crescer.pet.domain.Tipo;
import br.com.cwi.crescer.pet.exception.NegocioException;

@Service
public class IncluirCondominioService {

    public IncluirCondominioResponse incluir(IncluirCondominioRequest request) {

        // Validação simples (não tem dependência além do request)
        if (request.getConfig().isAceitaPet()
            && (request.getConfig().getTiposPet() == null
            || request.getConfig().getTiposPet().isEmpty())
        ) {
            throw new NegocioException("Deve informar a lista de tipos");
        }

        // Validação complexa (tem dependência - LISTA - além do request)
        Optional<Condominio> condominioDuplicado =
            CondominioController.LISTA.stream()
                .filter(c -> c.getNome().equals(request.getNome())).findFirst();

        if (condominioDuplicado.isPresent()) {
            throw new NegocioException("Já existe um condomínio com este nome");
        }

        // converte request para dominio
        String nome = request.getNome();
        boolean aceitaPet = request.getConfig().isAceitaPet();
        List<Tipo> tipos = request.getConfig().getTiposPet();

        // gerei identificador
        int id = CondominioController.LISTA.size() + 1;

        // converti
        Condominio novoCondominio = new Condominio(id, nome, aceitaPet, tipos);

        // persistindo/incluindo na lista
        CondominioController.LISTA.add(novoCondominio);

        // converte dominio para response
        IncluirCondominioResponse response = new IncluirCondominioResponse();
        response.setIdentificador(novoCondominio.getId());

        // retorna
        return response;
    }
}
