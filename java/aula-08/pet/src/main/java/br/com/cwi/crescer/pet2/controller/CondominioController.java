package br.com.cwi.crescer.pet2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.crescer.pet2.controller.request.IncluirCondominioRequest;
import br.com.cwi.crescer.pet2.controller.response.IncluirCondominioResponse;
import br.com.cwi.crescer.pet2.domain.Condominio;
import br.com.cwi.crescer.pet2.repository.CondominioRepository;
import br.com.cwi.crescer.pet2.service.IncluirCondominioService;

@RestController
@RequestMapping("/condominios")
public class CondominioController {

    @Autowired
    private IncluirCondominioService incluirCondominioService;

    // Não fazer
    @Autowired
    CondominioRepository condominioRepository;

    // Não fazer
    @GetMapping
    public List<Condominio> listar() {
        return condominioRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IncluirCondominioResponse incluir(
        @RequestBody @Valid IncluirCondominioRequest request) {

        return this.incluirCondominioService.incluir(request);
    }
}
