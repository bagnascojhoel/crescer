package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.domain.*;
import br.com.cwi.crescer.melevaai.exception.MotoristaNaoExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("motoristas")
public class MotoristaController {

    private List<Motorista> motoristaList = new ArrayList<>();

    @GetMapping("{numeroCPF}")
    @ResponseStatus(HttpStatus.OK)
    public Motorista mostrarMotorista(@PathVariable String numeroCPF) {

        final Motorista result = buscarMotoristaPorNumeroCPF(numeroCPF);
        if (result == null) throw new IllegalArgumentException();

        return result;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Motorista> listarMotoristas() {
        return motoristaList;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Motorista adicionarMotorista(@RequestBody Motorista motorista) {

        if (motoristaList.contains(motorista))
            throw new IllegalArgumentException("Motorista já adicionado.");

        motoristaList.add(motorista);
        return motorista;
    }

    @DeleteMapping("{numeroCPF}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Motorista deletarMotorista(@PathVariable String numeroCPF) {
        final Motorista motorista = buscarMotoristaPorNumeroCPF(numeroCPF);

        if (motorista == null)
            throw new MotoristaNaoExisteException();
        else {
            removerMotoristaPorNumeroCPF(numeroCPF);
            return motorista;
        }
    }

    private void removerMotoristaPorNumeroCPF(String numeroCPF) {
        motoristaList.removeIf(mot -> mot.getCpf().getNumero().equals(numeroCPF));
    }

    private Motorista buscarMotoristaPorNumeroCPF(String numeroCPF) {
        for (Motorista motorista : motoristaList) {
            if (motorista.getCpf().getNumero().equals(numeroCPF))
                return motorista;
        }

        return null;
    }
}
