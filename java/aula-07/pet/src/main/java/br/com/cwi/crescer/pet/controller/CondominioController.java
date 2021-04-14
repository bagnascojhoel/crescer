package br.com.cwi.crescer.pet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.crescer.pet.controller.request.IncluirCondominioRequest;
import br.com.cwi.crescer.pet.controller.response.CondominioResponse;
import br.com.cwi.crescer.pet.controller.response.IncluirCondominioResponse;
import br.com.cwi.crescer.pet.domain.Condominio;
import br.com.cwi.crescer.pet.service.IncluirCondominioService;

@RestController
@RequestMapping("/condominios")
public class CondominioController {

    @Autowired
    private IncluirCondominioService incluirCondominioService;

    public static final List<Condominio> LISTA = new ArrayList<Condominio>();

    @GetMapping
    public List<CondominioResponse> listar() {

        return LISTA.stream()
            .map(c -> {
                CondominioResponse response = new CondominioResponse();
                response.setIdentificador(c.getId());
                response.setNome(c.getNome());

                return response;
            })
            .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IncluirCondominioResponse incluir(
        @RequestBody @Valid IncluirCondominioRequest request) {

        return this.incluirCondominioService.incluir(request);
    }
}
