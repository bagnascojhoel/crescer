package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.controller.request.MotoristaRequest;
import br.com.cwi.crescer.melevaai.controller.response.MotoristaResponse;
import br.com.cwi.crescer.melevaai.domain.*;
import br.com.cwi.crescer.melevaai.exception.RegistroNaoEncontratoException;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import org.apache.tomcat.jni.Local;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("motoristas")
public class MotoristaController {

    public static List<Motorista> motoristaList = getMockMotorista();
    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping("{numeroCPF}")
    @ResponseStatus(HttpStatus.OK)
    public MotoristaResponse mostrarMotorista(@PathVariable String numeroCPF) {

        final Motorista motorista = buscarMotoristaPorNumeroCPF(numeroCPF);

        MotoristaResponse response = modelMapper.map(motorista, MotoristaResponse.class);

        return response;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Motorista> listarMotoristas() {
        return motoristaList;
        //TODO: nao precisa ser List<MotoristaResponse>?
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MotoristaResponse adicionarMotorista(@RequestBody @Valid MotoristaRequest request) {

        Motorista motorista = modelMapper.map(request, Motorista.class);

        if (motoristaList.contains(motorista))
            throw new ValidacaoNegocioException("Motorista já adicionado.");

        if(!motorista.temIdadeValida())
            throw new ValidacaoNegocioException("Motorista com idade inválida.");

        if(!motorista.getCnh().dataCNHValida())
            throw new ValidacaoNegocioException("Motorista com CNH vencida.");

        motorista.getCpf().validarCPF();

        motoristaList.add(motorista);

        MotoristaResponse response = modelMapper.map(motorista, MotoristaResponse.class);

        return response;
    }

    @DeleteMapping("{numeroCPF}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarMotorista(@PathVariable String numeroCPF) {
        final Motorista motorista = buscarMotoristaPorNumeroCPF(numeroCPF);

        Veiculo veiculo = VeiculoController.veiculoList
                .stream()
                .filter(v -> v.getProprietario().equals(motorista))
                .findFirst()
                .orElse(null);

        if(veiculo == null)
            removerMotoristaPorNumeroCPF(numeroCPF);
        else throw new ValidacaoNegocioException("Motorista vinculado a um veículo.");
    }

    private void removerMotoristaPorNumeroCPF(String numeroCPF) {
        motoristaList.removeIf(motorista -> motorista.getCpf().getNumero().equals(numeroCPF));
    }

    private Motorista buscarMotoristaPorNumeroCPF(String numeroCPF) {
        for (Motorista motorista : motoristaList) {
            if (motorista.getCpf().getNumero().equals(numeroCPF))
                return motorista;
        }
        throw new RegistroNaoEncontratoException("Motorista");
    }

    @PutMapping("{numeroCPF}/conta-virtual")
    @ResponseStatus(HttpStatus.OK)
    public void sacarSaldo(@PathVariable String numeroCPF, @RequestParam double valor) {
        if (valor < 0)
            throw new ValidacaoNegocioException("Não é possível sacar um valor negativo.");

        Motorista motorista = buscarMotoristaPorNumeroCPF(numeroCPF);

        motorista.sacar(valor);
    }

    public static List<Motorista> getMockMotorista() {
        List<Motorista> result = new ArrayList<>();
        Motorista motorista1 = new Motorista(
            "Jonas",
            "jonas.fonseca@gmail.com",
            LocalDate.parse("2000-12-12"),
            new CPF("63369321092"),
            15.00,
            4.7,
                new CNH(
                    "123456789",
                    Categoria.A,
                    LocalDate.parse("2050-12-12")
                )
        );

        Motorista motorista2 = new Motorista(
                "Eric Evans",
                "evans@ddd.com",
                LocalDate.parse("1999-02-20"),
                new CPF("23845868074"),
                1000,
                2.5,
                    new CNH(
                        "987654321",
                        Categoria.E,
                        LocalDate.parse("2020-12-12")
                    )
        );

        Motorista motorista3 = new Motorista(
                "Martin Fowler",
                "martin999@gmail.com",
                LocalDate.parse("1963-12-18"),
                new CPF("34434858041"),
                0,
                5,
                    new CNH(
                            "234567891",
                            Categoria.ACC,
                            LocalDate.parse("2100-05-05")
                    )
        );

        result.add(motorista1);
        result.add(motorista2);
        result.add(motorista3);

        return result;
    }

}
