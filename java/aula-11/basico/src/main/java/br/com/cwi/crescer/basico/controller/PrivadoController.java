package br.com.cwi.crescer.basico.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.crescer.basico.security.UsuarioAutenticado;
import br.com.cwi.crescer.basico.service.UsuarioLogadoService;

@RestController
@RequestMapping("/privado")
public class PrivadoController {

    @Autowired
    private UsuarioLogadoService usuarioLogadoService;

    @GetMapping
    public String privado() {

        UsuarioAutenticado usuarioAutenticado = usuarioLogadoService.get();

        System.out.println(usuarioAutenticado.getEmail());

        return "privado";
    }

    @RolesAllowed({ "ROLE_PASSAGEIRO" })
    @PostMapping("/passageiro")
    public String passageiro() {
        return "somente passageiro pode ver";
    }


}
