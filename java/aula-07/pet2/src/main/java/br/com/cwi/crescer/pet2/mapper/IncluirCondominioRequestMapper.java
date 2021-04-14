package br.com.cwi.crescer.pet2.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.cwi.crescer.pet2.controller.request.IncluirCondominioRequest;
import br.com.cwi.crescer.pet2.domain.Condominio;
import br.com.cwi.crescer.pet2.domain.Tipo;

@Component
public class IncluirCondominioRequestMapper {

//    @Autowired
//    private ModelMapper modelMapper;

    public Condominio apply(IncluirCondominioRequest request) {

        // converte request para dominio
        String nome = request.getNome();
        boolean aceitaPet = request.getConfig().isAceitaPet();
        List<Tipo> tipos = request.getConfig().getTiposPet();

        // conversão sem modelmapper
        Condominio novoCondominio = new Condominio();
        novoCondominio.setNome(nome);

        // conversão COM modelmapper - optei por não usar, pois não teria ganho
        // Condominio novoCondominio = modelMapper.map(request, Condominio.class);

        // não poderia usar o model mapper nestes campos
        // pois tem estrutura e nome diferente na origem e destino
        novoCondominio.setAceitaPet(aceitaPet);
        novoCondominio.setTiposPetAceitos(tipos);

        return novoCondominio;
    }
}
