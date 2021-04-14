package com.example.demo;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioRequest {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private List<String> roles;

}
