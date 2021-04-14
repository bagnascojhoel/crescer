package br.com.cwi.crescer.melevaai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.melevaai.domain.Passageiro;

@RestController
@RequestMapping("/passageiros")
public class PassageiroController {

    public static List<Passageiro> passageiros = new ArrayList<>();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Passageiro cadastrar(@RequestBody Passageiro passageiro) {
        passageiros.add(passageiro);

        return passageiro;
    }

    @GetMapping
    public List<Passageiro> listar() {
        return passageiros;
    }
}
