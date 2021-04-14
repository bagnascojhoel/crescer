package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.domain.Passageiro;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("passageiro")
public class PassageiroController {

    private static List<Passageiro> passageiroList = new ArrayList<>();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Passageiro adicionarPassageiro(@RequestBody Passageiro passageiro) {
        passageiroList.add(passageiro);
        return passageiro;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Passageiro> listarPassageiros() {
        return passageiroList;
    }
}
