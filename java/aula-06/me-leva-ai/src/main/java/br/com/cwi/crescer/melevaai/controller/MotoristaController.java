package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.controller.request.CadastrarMotoristaRequest;
import br.com.cwi.crescer.melevaai.controller.response.MotoristaResponse;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.service.motorista.BuscarMotoristaService;
import br.com.cwi.crescer.melevaai.service.motorista.CadastrarMotoristaService;
import br.com.cwi.crescer.melevaai.service.motorista.DeletarMotoristaService;
import br.com.cwi.crescer.melevaai.service.motorista.ListarMotoristaService;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    private BuscarMotoristaService buscarMotoristaService;

    @Autowired
    private CadastrarMotoristaService cadastrarMotoristaService;

    @Autowired
    private DeletarMotoristaService deletarMotoristaService;

    @Autowired
    private ListarMotoristaService listarMotoristaService;

    @GetMapping
    public List<Motorista> listar() {

        return listarMotoristaService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MotoristaResponse cadastrar(@RequestBody CadastrarMotoristaRequest cadastrarMotoristaRequest) {

//        return cadastrarMotoristaService.cadastrar(cadastrarMotoristaRequest, new M);
       return new MotoristaResponse();
    }

    @GetMapping("/{cpf}")
    public MotoristaResponse buscarPorCpf(@PathVariable("cpf") String cpf) {

        return buscarMotoristaService.buscar(cpf);
    }


    @DeleteMapping("/{cpf}")
    public void deletar(@PathVariable String cpf) {

        deletarMotoristaService.deletar(cpf);
    }
}