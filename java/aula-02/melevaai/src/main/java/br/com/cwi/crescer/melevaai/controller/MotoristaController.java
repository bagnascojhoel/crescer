package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.domain.CPF;
import br.com.cwi.crescer.melevaai.domain.CarteiraNacionalHabilitacao;
import br.com.cwi.crescer.melevaai.domain.Categoria;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("motorista")
public class MotoristaController {

    private static List<Motorista> motoristas = new ArrayList<>();

    @GetMapping
    public List<Motorista> listMotorista() {
        return motoristas;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Motorista adicionarMotorista(@RequestBody Motorista motorista){
        if(motoristas.contains(motorista)){
            throw new IllegalArgumentException();
        }

        motoristas.add(motorista);
        return motorista;
    }

    @GetMapping("{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public Motorista buscarPorCpf(@PathVariable String codigo){
        return this.buscaMotorista(codigo);
    }

    @DeleteMapping("{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable String cpf){
        final Motorista motorista = buscaMotorista(cpf);
        motoristas.remove(motorista);
    }

    private Motorista buscaMotorista(String cpf){
        for (Motorista motorista: motoristas) {
            if(motorista.getCpf().getNumero().equals(cpf)){
                return motorista;
            }
        }
        throw new IllegalArgumentException();
    }



}
