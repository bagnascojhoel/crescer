package br.com.cwi.crescer.heranca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.crescer.heranca.controller.request.PFRequest;
import br.com.cwi.crescer.heranca.controller.request.PJRequest;
import br.com.cwi.crescer.heranca.domain.Pessoa;
import br.com.cwi.crescer.heranca.domain.PessoaFisica;
import br.com.cwi.crescer.heranca.domain.PessoaJuridica;
import br.com.cwi.crescer.heranca.repository.PessoaFisicaRepository;
import br.com.cwi.crescer.heranca.repository.PessoaJuridicaRepository;
import br.com.cwi.crescer.heranca.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping("/fisica")
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaFisica incluirPF(@RequestBody @Valid PFRequest request) {

        final PessoaFisica pf = new PessoaFisica();
        pf.setNome(request.getNome());
        pf.setCpf(request.getCpf());

        return pessoaFisicaRepository.save(pf);
    }

    @GetMapping("/fisica")
    public List<PessoaFisica> listarPF() {
        return pessoaFisicaRepository.findAll();
    }

    @PostMapping("/juridica")
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaJuridica incluirPJ(@RequestBody @Valid PJRequest request) {

        final PessoaJuridica pj = new PessoaJuridica();
        pj.setNome(request.getNome());
        pj.setCnpj(request.getCnpj());
        pj.setNomeFantasia(request.getFantasia());

        return pessoaJuridicaRepository.save(pj);
    }

    @GetMapping("/juridica")
    public List<PessoaJuridica> listarPJ() {
        return pessoaJuridicaRepository.findAll();
    }

    @GetMapping
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }
}
