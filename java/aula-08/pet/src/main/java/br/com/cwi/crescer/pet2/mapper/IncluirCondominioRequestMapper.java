package br.com.cwi.crescer.pet2.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.cwi.crescer.pet2.controller.request.IncluirCondominioRequest;
import br.com.cwi.crescer.pet2.domain.Condominio;
import br.com.cwi.crescer.pet2.domain.Tipo;

@Component
public class IncluirCondominioRequestMapper {

    public Condominio apply(IncluirCondominioRequest request) {

        String nome = request.getNome();
        boolean aceitaPet = request.getConfig().isAceitaPet();
        List<Tipo> tipos = request.getConfig().getTiposPet();

        Condominio novoCondominio = new Condominio();
        novoCondominio.setNome(nome);
        novoCondominio.setAceitaPet(aceitaPet);
//        novoCondominio.setTiposPetAceitos(tipos);

        return novoCondominio;
    }
}
