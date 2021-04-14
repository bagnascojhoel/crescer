package br.com.cwi.crescer.melevaai.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.cwi.crescer.melevaai.controller.request.MotoristaRequest;
import br.com.cwi.crescer.melevaai.controller.response.MotoristaResponse;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.exception.RegistroNaoEncontradoException;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import br.com.cwi.crescer.melevaai.service.BuscarMotoristaPorCpfService;
import br.com.cwi.crescer.melevaai.service.CadastrarMotoristaService;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    private BuscarMotoristaPorCpfService buscarMotoristaPorCpfService;

    @Autowired
    private CadastrarMotoristaService cadastrarMotoristaService;

    @Autowired
    private MotoristaRepository motoristaRepository;


    @GetMapping
    public List<Motorista> listar() {

        return motoristaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MotoristaResponse cadastrar(@RequestBody MotoristaRequest motoristaRequest) {

        return cadastrarMotoristaService.cadastrar(motoristaRequest);
    }

    @GetMapping("/{cpf}")
    public MotoristaResponse buscarPorCpf(@PathVariable("cpf") String cpf) {

        return buscarMotoristaPorCpfService.buscar(cpf);
    }


    @DeleteMapping("/{cpf}")
    public void deletar(@PathVariable String cpf) {

        final Optional<Motorista> motorista = motoristaRepository.findByCpf(cpf);

        if (!motorista.isPresent()) {
            throw new RegistroNaoEncontradoException(Motorista.class.getName());
        }

//
//        if (!motorista.isPresent()) {
//            throw new RegistroNaoEncontradoException(Motorista.class.getName());
//        }
        ///asdfasfd


        motoristaRepository.delete(motorista.get());
    }
}