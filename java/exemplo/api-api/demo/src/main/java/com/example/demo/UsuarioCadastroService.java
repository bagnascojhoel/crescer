package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioCadastroService {

    @Autowired
    ApiCadastro apiCadastro;

    public UsuarioResponse  cadastrarUsuario(UsuarioRequest usuarioRequest){
        return apiCadastro.cadastrarUsuario(usuarioRequest);
    }



}
