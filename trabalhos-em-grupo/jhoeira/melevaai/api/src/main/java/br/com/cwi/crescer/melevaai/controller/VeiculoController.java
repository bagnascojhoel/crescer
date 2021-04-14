package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.controller.request.VeiculoRequest;
import br.com.cwi.crescer.melevaai.controller.response.VeiculoResponse;
import br.com.cwi.crescer.melevaai.domain.*;
import br.com.cwi.crescer.melevaai.exception.RegistroNaoEncontratoException;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("veiculos")
public class VeiculoController {

    public static List<Veiculo> veiculoList = getMockVeiculos();
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoResponse adicionarVeiculo(@RequestBody @Valid VeiculoRequest veiculoRequest) {
        System.out.println(veiculoRequest.getQtdLugares());

        Motorista proprietario = MotoristaController.motoristaList
                .stream()
                .filter(motorista -> motorista.getCpf().getNumero().equals(veiculoRequest.getCPFProprietario()))
                .findFirst()
                .orElseThrow(() -> new RegistroNaoEncontratoException("Motorista"));

        System.out.println(proprietario.getCpf());

        Veiculo veiculo = modelMapper.map(veiculoRequest, Veiculo.class);

        //TODO: categorias iguais as da vida real??
        if(veiculo.getCategoria() != proprietario.getCnh().getCategoria())
            throw new ValidacaoNegocioException("O proprietário não é apto a dirigir este veiculo.");

        veiculo.setProprietario(proprietario);

        veiculoList.add(veiculo);

        VeiculoResponse response = modelMapper.map(veiculo, VeiculoResponse.class);

        return response;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Veiculo> listarVeiculos() {
        return veiculoList;
    }

    @GetMapping("veiculos-disponiveis")
    @ResponseStatus(HttpStatus.OK)
    public List<Veiculo> listarVeiculosDisponiveis() {
        return buscarVeiculosDisposíveis(CorridaController.buscarMotoristasEmCorrida());
    }

    public static boolean existeVeiculoDisponivel(List<Motorista> motoristasOcupados) {
        return buscarVeiculosDisposíveis(motoristasOcupados).size() > 0;
    }

    public static List<Veiculo> buscarVeiculosDisposíveis(List<Motorista> motoristasOcupados) {
        return veiculoList
                .stream()
                .filter(v -> !motoristasOcupados.contains(v.getProprietario()))
                .collect(Collectors.toList());
    }

    @GetMapping("categorias")
    @ResponseStatus(HttpStatus.OK)
    public List<Categoria> listarCategorias() {
        return Arrays.asList(Categoria.values());
    }

    @GetMapping("cores")
    @ResponseStatus(HttpStatus.OK)
    public List<Cor> listarCores() {
        return Arrays.asList(Cor.values());
    }

    @GetMapping("marcas")
    @ResponseStatus(HttpStatus.OK)
    public List<Marca> listarMarcas() {
        return Arrays.asList(Marca.values());
    }

    public static List<Veiculo> getMockVeiculos() {
        List<Veiculo> result = new ArrayList<>();
        Veiculo veiculo1 = new Veiculo(
                new Placa("RIO2A18"),
                Marca.AUDI,
                "SUV",
                2021,
                Cor.PRETO,
                new URL("https://www.minimundi.com.br/cdn/imagens/produtos/det/miniatura-carro-audi-r8-gt-premiere-edition-1-18-maisto-36190-011036_a.jpg"),
                Categoria.A,
                2,
                MotoristaController.getMockMotorista().get(0)
        );

        Veiculo veiculo2 = new Veiculo(
                new Placa("LSU3J43"),
                Marca.JAC,
                "Esportivo",
                1800,
                Cor.BRANCO,
                new URL("https://www.planetcarsz.com/assets/uploads/4b1809e1c46f81e737e0e8b542f25f5d.jpg"),
                Categoria.E,
                5,
                MotoristaController.getMockMotorista().get(1)
        );

        Veiculo veiculo3 = new Veiculo(
                new Placa("EMP0A14"),
                Marca.MERCEDES_BENZ,
                "Coletivo",
                1986,
                Cor.PRATA,
                new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSo2gCO3SZ6rS81mGFie90QG93knW1CzGzuUQ&usqp=CAU"),
                Categoria.ACC,
                999,
                MotoristaController.getMockMotorista().get(2)
        );

        result.add(veiculo1);
        result.add(veiculo2);
        result.add(veiculo3);

        return result;
    }
}
