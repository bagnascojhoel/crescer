package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioCadastroService usuarioCadastroService;

    @PostMapping
    public UsuarioResponse cadastrarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        return usuarioCadastroService.cadastrarUsuario(usuarioRequest);
    }


}
