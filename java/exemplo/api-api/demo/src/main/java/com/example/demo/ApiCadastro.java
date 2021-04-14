package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "register", url = "http://52.191.131.0:3000/register")
public interface ApiCadastro {

    @RequestMapping(method =  RequestMethod.POST)
    UsuarioResponse cadastrarUsuario(UsuarioRequest usuarioRequest);

}
