package br.com.cwi.crescer.pet2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.pet2.mapper.IncluirCondominioRequestMapper;
import br.com.cwi.crescer.pet2.mapper.IncluirCondominioResponseMapper;
import br.com.cwi.crescer.pet2.repository.CondominioRepository;
import br.com.cwi.crescer.pet2.validator.IncluirCondominioValidator;
import br.com.cwi.crescer.pet2.controller.request.IncluirCondominioRequest;
import br.com.cwi.crescer.pet2.controller.response.IncluirCondominioResponse;
import br.com.cwi.crescer.pet2.domain.Condominio;

@Service
public class IncluirCondominioService {

    @Autowired
    private IncluirCondominioValidator incluirCondominioValidator;

    @Autowired
    private ValidarCondominioDuplicadoService validarCondominioDuplicadoService;

    @Autowired
    private IncluirCondominioRequestMapper requestMapper;

    @Autowired
    private IncluirCondominioResponseMapper responseMapper;

    @Autowired
    private CondominioRepository condominioRepository;

    public IncluirCondominioResponse incluir(IncluirCondominioRequest request) {

        incluirCondominioValidator.accept(request);

        validarCondominioDuplicadoService.accept(request);

        Condominio novoCondominio = requestMapper.apply(request);

        condominioRepository.save(novoCondominio);

        return responseMapper.apply(novoCondominio);
    }
}
