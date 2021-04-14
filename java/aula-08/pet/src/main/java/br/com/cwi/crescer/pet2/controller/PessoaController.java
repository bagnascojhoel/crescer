package br.com.cwi.crescer.pet2.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.crescer.pet2.controller.request.IncluirPessoaRequest;
import br.com.cwi.crescer.pet2.controller.response.PessoaResponse;
import br.com.cwi.crescer.pet2.domain.Condominio;
import br.com.cwi.crescer.pet2.domain.Cor;
import br.com.cwi.crescer.pet2.domain.Pessoa;
import br.com.cwi.crescer.pet2.repository.CondominioRepository;
import br.com.cwi.crescer.pet2.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CondominioRepository condominioRepository;

    @GetMapping
    public List<PessoaResponse> listar() {
        return pessoaRepository.findAll().stream()
            .map(p -> {
                PessoaResponse response = new PessoaResponse();
                response.setId(p.getId());
                response.setNome(p.getNome());
                response.setNomeCondominio(p.getCondominio().getNome());
                return response;
            })
            .collect(Collectors.toList());
    }

    @GetMapping("/search")
    public List<PessoaResponse> buscarPorCor(@RequestParam("cor") Cor cor) {
        return pessoaRepository.findByCor(cor).stream()
            .map(p -> {
                PessoaResponse response = new PessoaResponse();
                response.setId(p.getId());
                response.setNome(p.getNome());
                response.setNomeCondominio(p.getCondominio().getNome());
                return response;
            })
            .collect(Collectors.toList());
    }

    @GetMapping("/search2")
    public List<PessoaResponse> buscarPorCorENome(@RequestParam("cor") Cor cor, @RequestParam("nome") String nome) {
        return pessoaRepository.findByCorAndNome(cor, nome).stream()
            .map(p -> {
                PessoaResponse response = new PessoaResponse();
                response.setId(p.getId());
                response.setNome(p.getNome());
                response.setNomeCondominio(p.getCondominio().getNome());
                return response;
            })
            .collect(Collectors.toList());
    }

    // Não fazer tudo na controller
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer incluir(@RequestBody @Valid IncluirPessoaRequest request) {

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(request.getNome());
        pessoa.setCor(request.getCor());

        Condominio condominio = condominioRepository.findById(request.getIdCondominio());

        pessoa.setCondominio(condominio);

        return pessoaRepository.save(pessoa).getId();
    }
}
