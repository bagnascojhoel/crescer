package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.controller.request.VeiculoRequest;
import br.com.cwi.crescer.melevaai.controller.response.VeiculoResponse;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.domain.Veiculo;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;

import br.com.cwi.crescer.melevaai.service.VeiculoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoResponse cadastrar(@RequestBody @Valid VeiculoRequest veiculoRequest) {
        return veiculoService.salvar(veiculoRequest);
    }

//    @GetMapping
//    public List<Veiculo> listar() {
//        return veiculos;
//    }

}
