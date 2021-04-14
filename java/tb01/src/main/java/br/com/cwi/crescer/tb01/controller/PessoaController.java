package br.com.cwi.crescer.tb01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.crescer.tb01.controller.request.PessoaRequest;
import br.com.cwi.crescer.tb01.domain.Pessoa;
import br.com.cwi.crescer.tb01.exception.NegocioException;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    public static final List<Pessoa> PESSOAS = new ArrayList<>();

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody @Valid PessoaRequest request) {

        Pessoa novaPessoa = mapper.map(request, Pessoa.class);

        PessoaController.PESSOAS.add(novaPessoa);
    }

    @GetMapping
    public List<Pessoa> listar() {

//        return Arrays.asList(PESSOAS.get(15));

//        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "meu erro");

        return PessoaController.PESSOAS;
    }

    @GetMapping("/{cpf}")
    public Pessoa buscarPorCpf(@PathVariable("cpf") String cpf) {

        Optional<Pessoa> pessoa = PessoaController.PESSOAS.stream()
            .filter(p -> p.getCpf().equals(cpf))
            .findFirst();

        if (pessoa.isPresent()) {
            return pessoa.get();
        }

//        throw new PessoaNaoEncontradaException();

//        throw new NaoEncontradoException("pessoa não encontrada");

        throw new NegocioException("idade do passageiro é inválida");

    }
}
