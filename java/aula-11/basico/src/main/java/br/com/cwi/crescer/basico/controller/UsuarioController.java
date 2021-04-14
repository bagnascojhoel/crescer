package br.com.cwi.crescer.basico.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.crescer.basico.controller.request.AutenticarUsuarioRequest;
import br.com.cwi.crescer.basico.controller.request.MotoristaRequest;
import br.com.cwi.crescer.basico.controller.request.PassageiroRequest;
import br.com.cwi.crescer.basico.controller.response.AutenticarUsuarioResponse;

@RestController
@RequestMapping("/publico/usuario")
public class UsuarioController {

    @PostMapping("/motorista/incluir")
    public String incluirMotorista(MotoristaRequest request) {

        // segue as validações

        // ALTERAÇÃO
        // incluir com sucesso o usuário na api de autenticação (BH) => POST http://52.191.131.0:3000/register

        // Segue processo atual

        return null;
    }

    @PostMapping("/passageiro/incluir")
    public String incluirPassageiro(PassageiroRequest request) {

        // segue as validações

        // ALTERAÇÃO
        // incluir com sucesso o usuário na api de autenticação (BH) => POST http://52.191.131.0:3000/register

        // Segue processo atual

        return null;
    }

    @PostMapping("/autenticar")
    public AutenticarUsuarioResponse autenticar(AutenticarUsuarioRequest request) {

        // recebe request com email e senha

        // logar na api de autenticação (BH) = POST http://52.191.131.0:3000/login

        // receber e retornar o token

        return null;
    }

}
