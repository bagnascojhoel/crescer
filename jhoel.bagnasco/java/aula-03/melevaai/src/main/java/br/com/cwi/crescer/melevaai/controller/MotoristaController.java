package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.controller.request.MotoristaRequest;
import br.com.cwi.crescer.melevaai.controller.response.MotoristaResponse;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.exception.MotoristaNaoExisteException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("motoristas")
public class MotoristaController {

    private static List<Motorista> motoristaList = new ArrayList<>();
    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping("{numeroCPF}")
    @ResponseStatus(HttpStatus.OK)
    public MotoristaResponse mostrarMotorista(@PathVariable String numeroCPF) {

        final Motorista motorista = buscarMotoristaPorNumeroCPF(numeroCPF);
        if (motorista == null) throw new IllegalArgumentException();

        MotoristaResponse response = modelMapper.map(motorista, MotoristaResponse.class);

        return response;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Motorista> listarMotoristas() {
        return motoristaList;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MotoristaResponse adicionarMotorista(@RequestBody @Valid MotoristaRequest request) {

        Motorista motorista = modelMapper.map(request, Motorista.class);

        if (motoristaList.contains(motorista))
            throw new IllegalArgumentException("Motorista já adicionado.");

        motoristaList.add(motorista);

        MotoristaResponse response = modelMapper.map(motorista, MotoristaResponse.class);

        return response;
    }

    @DeleteMapping("{numeroCPF}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarMotorista(@PathVariable String numeroCPF) {
        final Motorista motorista = buscarMotoristaPorNumeroCPF(numeroCPF);

        if (motorista == null)
            throw new MotoristaNaoExisteException();
        else
            removerMotoristaPorNumeroCPF(numeroCPF);
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
