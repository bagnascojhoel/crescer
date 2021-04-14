package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.domain.Veiculo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("veiculo")
public class VeiculoController {

    private static List<Veiculo> veiculoList = new ArrayList<>();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo adicionarVeiculo(@RequestBody Veiculo veiculo) {
        veiculoList.add(veiculo);
        return veiculo;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Veiculo> listarVeiculos() {
        return veiculoList;
    }
}
