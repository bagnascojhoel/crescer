package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.controller.request.PassageiroRequest;
import br.com.cwi.crescer.melevaai.controller.response.PassageiroResponse;
import br.com.cwi.crescer.melevaai.domain.CPF;
import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("passageiros")
public class PassageiroController {

    public static List<Passageiro> passageiroList = getMockPassageiros();
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PassageiroResponse adicionarPassageiro(@RequestBody @Valid PassageiroRequest request) {

        Passageiro passageiro = modelMapper.map(request, Passageiro.class);

        if (passageiroList.contains(passageiro))
            throw new ValidacaoNegocioException("Passageiro já adicionado.");

        passageiro.validarIdade();

        passageiro.getCpf().validarCPF();

        passageiroList.add(passageiro);

        PassageiroResponse response = modelMapper.map(passageiro, PassageiroResponse.class);
        
        return response;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Passageiro> listarPassageiros() {
        return passageiroList;
    }

    @PutMapping("{cpf}/conta-virtual")
    @ResponseStatus(HttpStatus.OK)
    public void adicionarCredito(@PathVariable String cpf, @RequestParam double valor) {
        if (valor < 0)
            throw new ValidacaoNegocioException("Não é possível adicionar um valor negativo.");

        Passageiro passageiro = passageiroList
                .stream()
                .filter(p -> p.getCpf().getNumero().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new ValidacaoNegocioException("Passageiro não encontrado."));

        passageiro.depositar(valor);
    }

    @GetMapping("{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public PassageiroResponse mostrarPassageiro(@PathVariable String cpf) {
        PassageiroResponse response = modelMapper.map(buscarPassageiroPorCPF(cpf), PassageiroResponse.class);
        return response;
    }

    public static boolean existePassageiroPorCpf(String cpf) {
        return buscarPassageiroPorCPF(cpf) != null;
    }

    public static Passageiro buscarPassageiroPorCPF(String cpf) {
        return passageiroList
                .stream()
                .filter(p -> p.getCpf().getNumero().equals(cpf))
                .findAny()
                .orElse(null);
    }

    public static List<Passageiro> getMockPassageiros() {
        List<Passageiro> result = new ArrayList<>();

        Passageiro passageiro1 = new Passageiro(
                "Kent Beck",
                "beck@xp.com",
                LocalDate.parse("1961-03-31"),
                new CPF("96475818070"),
                300,
                4.3
        );

        Passageiro passageiro2 = new Passageiro(
                "Robert Cecil Martin",
                "martin@cleancoder.com",
                LocalDate.parse("1952-03-31"),
                new CPF("09125251007"),
                0,
                1
        );

        Passageiro passageiro3 = new Passageiro(
                "Frederick P. Brooks Jr.",
                "fredinho@manmonth.net",
                LocalDate.parse("1931-04-19"),
                new CPF("27100629098"),
                5,
                5
        );

        result.add(passageiro1);
        result.add(passageiro2);
        result.add(passageiro3);

        return result;
    }
}
