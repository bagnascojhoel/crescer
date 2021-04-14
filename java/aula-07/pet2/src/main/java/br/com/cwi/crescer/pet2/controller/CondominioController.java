package br.com.cwi.crescer.pet2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.crescer.pet2.controller.request.IncluirCondominioRequest;
import br.com.cwi.crescer.pet2.controller.response.IncluirCondominioResponse;
import br.com.cwi.crescer.pet2.service.IncluirCondominioService;

@RestController
@RequestMapping("/condominios")
public class CondominioController {

    @Autowired
    private IncluirCondominioService incluirCondominioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IncluirCondominioResponse incluir(
        @RequestBody @Valid IncluirCondominioRequest request) {

        return this.incluirCondominioService.incluir(request);
    }
}
