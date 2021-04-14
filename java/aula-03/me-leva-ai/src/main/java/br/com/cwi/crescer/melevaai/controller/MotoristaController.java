package br.com.cwi.crescer.melevaai.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.exception.RegistroNaoEncontradoException;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    public static List<Motorista> motoristas = new ArrayList<>();

    @GetMapping
    public List<Motorista> listar() {

        return motoristas;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Motorista cadastrar(@RequestBody @Valid Motorista motorista) {

        if (Motorista.IDADE_MINIMA > motorista.getIdade()) {
            throw new ValidacaoNegocioException();
        }

        if (motorista.getCnh().isVencida()) {
            throw new ValidacaoNegocioException();
        }

        //TODO CPF inválido - fazer o método dentra da classe CPF

        if (motoristas.contains(motorista)) {
            throw new RegistroNaoEncontradoException();
        }

        motoristas.add(motorista);

        return motorista;
    }

    @GetMapping("/{cpf}")
    public Motorista buscarPorCpf(@PathVariable("cpf") String cpf) {
        return motoristas
            .stream()
            .filter(m -> m.getCpf().getNumero().equals(cpf))
            .findFirst()
            .orElseThrow(() -> new RegistroNaoEncontradoException());
    }


    @DeleteMapping("/{cpf}")
    public void deletar(@PathVariable String cpf) {

        final Motorista motorista = buscarPorCpf(cpf);

        motoristas.remove(motorista);
    }
}