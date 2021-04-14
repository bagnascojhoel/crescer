package br.com.cwi.crescer.heranca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.crescer.heranca.controller.request.AlterarEnderecoRequest;
import br.com.cwi.crescer.heranca.controller.request.IncluirMotoristaRequest;
import br.com.cwi.crescer.heranca.controller.response.MotoristaResponse;
import br.com.cwi.crescer.heranca.domain.CNH;
import br.com.cwi.crescer.heranca.domain.CPF;
import br.com.cwi.crescer.heranca.domain.Motorista;
import br.com.cwi.crescer.heranca.repository.MotoristaRepository;
import br.com.cwi.crescer.heranca.service.AlterarEnderecoMotoristaService;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    // Não injetar repository na controller
    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private AlterarEnderecoMotoristaService alterarEnderecoMotoristaService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // Não retorna dominio. Retornar response.
    @GetMapping
    public List<Motorista> listar() {
        return motoristaRepository.findAll();
    }

    // Não fazer tudo na controller, usar service, validator, mapper e repository.
    @PostMapping
    public Motorista incluir(@RequestBody @Valid IncluirMotoristaRequest request) {

        String nome = request.getNome();
        String numeroCpf = request.getCpf();
        String numeroCnh = request.getNumeroCnh();

        CPF cpf = new CPF();
        cpf.setNumero(numeroCpf);

        CNH cnh = new CNH();
        cnh.setNumero(numeroCnh);

        Motorista motorista = new Motorista();
        motorista.setNome(nome);
        motorista.setCpf(cpf);
        motorista.setCnh(cnh);

        return motoristaRepository.save(motorista);
    }

    // certinho
    @PutMapping("/{id}/endereco")
    public MotoristaResponse alterarEndereco(
        @PathVariable Integer id,
        @RequestBody @Valid AlterarEnderecoRequest request) {

        return alterarEnderecoMotoristaService.alterar(id, request);
    }
}
