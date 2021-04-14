package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.controller.request.CorridaRequest;
import br.com.cwi.crescer.melevaai.controller.response.CorridaChamarResponse;
import br.com.cwi.crescer.melevaai.controller.response.CorridaIniciarResponse;
import br.com.cwi.crescer.melevaai.domain.*;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("corridas")
public class CorridaController {

    private static final int PASSO_IDENTIFICADOR = 1;

    public static List<Corrida> corridaList = getMockCorridas();

    private ModelMapper modelMapper = new ModelMapper();


    /**
     * Quando a corrida é iniciada, o status da corrida é setado em StatusCorrida.Chamada
     * @param cpfPassageiro: cpf do passageiro via path
     * @param request: objeto da corrida recebido via body
     * @return CorridaResponse para a chamada da corrida
     */
    @PostMapping("passageiros/{cpfPassageiro}")
    @ResponseStatus(HttpStatus.CREATED)
    public CorridaChamarResponse solicitarCorrida(@PathVariable String cpfPassageiro, @RequestBody @Valid CorridaRequest request) {

        if(!PassageiroController.existePassageiroPorCpf(cpfPassageiro))
            throw new ValidacaoNegocioException("Passageiro não listado.");

        if (estaEmCorrida(cpfPassageiro))
            throw new ValidacaoNegocioException("Passageiro já está em corrida.");

        if(!VeiculoController.existeVeiculoDisponivel(buscarMotoristasEmCorrida()))
            throw new ValidacaoNegocioException("Sem veículos disponíveis.");

        Passageiro passageiro = PassageiroController.buscarPassageiroPorCPF(cpfPassageiro);
        Corrida corrida = mapRequestToCorrida(request, passageiro);

        corridaList.add(corrida);

        CorridaChamarResponse response = modelMapper.map(corrida, CorridaChamarResponse.class);

        return response;
    }

    private Corrida mapRequestToCorrida(CorridaRequest request, Passageiro passageiro) {
        Corrida result = modelMapper.map(request, Corrida.class);
        result.setIdentificador(corridaList.size() + PASSO_IDENTIFICADOR);
        result.setTempoChegada(Corrida.calcularTempoChegadaEstimado());
        result.setPassageiro(passageiro);
        result.setVeiculo(getVeiculoDisponivelAleatorio());
        result.setStatus(StatusCorrida.CHAMADA);

        return result;
    }

    private Veiculo getVeiculoDisponivelAleatorio() {
        List<Veiculo> veiculosDisponiveis = VeiculoController.buscarVeiculosDisposíveis(buscarMotoristasEmCorrida());
        int posicaoAleatoria = new Random().nextInt(veiculosDisponiveis.size());

        return veiculosDisponiveis.get(posicaoAleatoria);
    }

    private boolean estaEmCorrida(String cpfPassageiro) {
        return buscarCorridasEmAndamento().stream()
                .anyMatch(c -> c.getPassageiro().getCpf().getNumero().equals(cpfPassageiro));
    }

    public static List<Motorista> buscarMotoristasEmCorrida() {
        List<Motorista> result = new ArrayList<>();

        corridaList.stream().forEach(c -> {
            if(c.getStatus() != StatusCorrida.FINALIZADA)
                result.add(c.getVeiculo().getProprietario());
        });

        return result;
    }

    @GetMapping("em-andamento")
    @ResponseStatus(HttpStatus.OK)
    public List<Corrida> listarCorridasEmAndamento() {
        return buscarCorridasEmAndamento();
    }

    public static List<Corrida> buscarCorridasEmAndamento() {
        return corridaList.stream()
                .filter(c -> c.getStatus() != StatusCorrida.FINALIZADA)
                .collect(Collectors.toList());
    }

    @PostMapping("{codCorrida}")
    @ResponseStatus(HttpStatus.CREATED)
    public CorridaIniciarResponse iniciarCorrida(@PathVariable String codCorrida) {
        Corrida corrida = buscarCorrida(codCorrida);

        if(corrida.getStatus() != StatusCorrida.CHAMADA)
            throw new ValidacaoNegocioException("Corrida já foi iniciada.");

        corrida.setDataHoraInicio(LocalDateTime.now());
        corrida.calcValorEstimado();
        corrida.setStatus(StatusCorrida.INICIADA);

        CorridaIniciarResponse response = modelMapper.map(corrida, CorridaIniciarResponse.class);
        response.setDataHoraChegadaEstimada(LocalDateTime.now().plusSeconds(Math.round(corrida.getTempoEstimado())));

        return response;
    }

    private Corrida buscarCorrida(String codigoCorrida) {
        return corridaList
                .stream()
                .filter(c -> c.getIdentificador() == Integer.parseInt(codigoCorrida))
                .findFirst()
                .orElseThrow(() -> new ValidacaoNegocioException("Corrida não encontrada."));
    }

    @PutMapping("{codCorrida}")
    @ResponseStatus(HttpStatus.OK)
    public void finalizarCorrida(@PathVariable String codCorrida) {
        Corrida corrida = corridaList
                .stream()
                .filter(c -> c.getIdentificador() == Integer.parseInt(codCorrida))
                .findFirst()
                .orElseThrow(() -> new ValidacaoNegocioException("Corrida não encontrada."));

        if(corrida.getStatus() == StatusCorrida.CHAMADA)
            throw new ValidacaoNegocioException("Corrida ainda não foi iniciada.");
        if(corrida.getStatus() != StatusCorrida.INICIADA)
            throw new ValidacaoNegocioException("Corrida já foi finalizada.");

        corrida.setDataHoraFim(LocalDateTime.now());

        long segundos = corrida.getDataHoraInicio().until(corrida.getDataHoraFim(), ChronoUnit.SECONDS);
        corrida.setValorReal(segundos*Corrida.VALOR_POR_SEGUNDO);

        corrida.realizarTransicoesPagamento();

        //TODO: verificar oq fazer quando a transferencia nao for realizada

        corrida.setStatus(StatusCorrida.FINALIZADA);
    }

    @GetMapping("passageiros/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public List<Corrida> listarCorridas(@PathVariable String cpf) {
        Passageiro passageiro = PassageiroController.passageiroList
                .stream()
                .filter(p -> p.getCpf().getNumero().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new ValidacaoNegocioException("Passageiro não encontrado."));

        List<Corrida> corridas = corridaList
                .stream()
                .filter(c -> c.getPassageiro().equals(passageiro))
                .collect(Collectors.toList());
        if(corridas.size() <= 0)
            throw new ValidacaoNegocioException("Passageiro sem nenhuma corrida registrada.");

        return corridas;
    }

    @PostMapping("{codCorrida}/passageiros/avaliacao")
    @ResponseStatus(HttpStatus.OK)
    public void avaliacaoParaPassageiro(@PathVariable String codCorrida, @RequestParam int nota) {
        Corrida corrida = corridaList
                .stream()
                .filter(c -> c.getIdentificador() == Integer.parseInt(codCorrida))
                .findFirst()
                .orElseThrow(() -> new ValidacaoNegocioException("Corrida não encontrada."));

        if(nota < Corrida.NOTA_MINIMA && nota > Corrida.NOTA_MAXIMA)
            throw new ValidacaoNegocioException("Nota fora do range aceitável.");

        if(corrida.getNotaParaPassageiro() != 0)
            throw new ValidacaoNegocioException("Esta corrida já foi avaliada.");

        if(corrida.getStatus() != StatusCorrida.FINALIZADA)
            throw new ValidacaoNegocioException("Corrida ainda não foi finalizada.");

        corrida.setNotaParaPassageiro(nota);

        corrida.getPassageiro().calcularMedia();
    }

    @PostMapping("{codCorrida}/motoristas/avaliacao")
    @ResponseStatus(HttpStatus.OK)
    public void avaliacaoParaMotorista(@PathVariable String codCorrida, @RequestParam int nota) {
        Corrida corrida = corridaList
                .stream()
                .filter(c -> c.getIdentificador() == Integer.parseInt(codCorrida))
                .findFirst()
                .orElseThrow(() -> new ValidacaoNegocioException("Corrida não encontrada."));

        if(nota < Corrida.NOTA_MINIMA && nota > Corrida.NOTA_MAXIMA)
            throw new ValidacaoNegocioException("Nota fora do range aceitável.");

        if(corrida.getNotaParaMotorista() != 0)
            throw new ValidacaoNegocioException("Esta corrida já foi avaliada.");

        if(corrida.getStatus() != StatusCorrida.FINALIZADA)
            throw new ValidacaoNegocioException("Corrida ainda não foi finalizada.");

        corrida.setNotaParaMotorista(nota);

        corrida.getVeiculo().getProprietario().calcularMedia();
    }

    public static List<Corrida> getMockCorridas() {
        List<Corrida> result = new ArrayList<>();

        Corrida corrida1 = new Corrida(
                1,
                PassageiroController.getMockPassageiros().get(0),
                VeiculoController.getMockVeiculos().get(0),
                new Ponto(159, 234),
                new Ponto(0, 0),
                Corrida.calcularTempoChegadaEstimado(),
                LocalDateTime.now(),
                LocalDateTime.now().plusSeconds(Corrida.calcularTempoChegadaEstimado()),
                15,
                Corrida.calcularTempoChegadaEstimado(),
                12,
                StatusCorrida.FINALIZADA,
                4,
                5
        );

        Corrida corrida2 = new Corrida(
                2,
                PassageiroController.getMockPassageiros().get(0),
                VeiculoController.getMockVeiculos().get(1),
                new Ponto(159, 234),
                new Ponto(0, 0),
                Corrida.calcularTempoChegadaEstimado(),
                LocalDateTime.now(),
                LocalDateTime.now().plusSeconds(Corrida.calcularTempoChegadaEstimado()),
                53,
                Corrida.calcularTempoChegadaEstimado(),
                3,
                StatusCorrida.FINALIZADA,
                1,
                1
        );

        Corrida corrida3 = new Corrida(
                3,
                PassageiroController.getMockPassageiros().get(1),
                VeiculoController.getMockVeiculos().get(2),
                new Ponto(159, 234),
                new Ponto(0, 0),
                Corrida.calcularTempoChegadaEstimado(),
                LocalDateTime.now(),
                LocalDateTime.now().plusSeconds(Corrida.calcularTempoChegadaEstimado()),
                98,
                Corrida.calcularTempoChegadaEstimado(),
                99,
                StatusCorrida.FINALIZADA,
                5,
                1
        );

        Corrida corrida4 = new Corrida(
                4,
                PassageiroController.getMockPassageiros().get(2),
                VeiculoController.getMockVeiculos().get(2),
                new Ponto(159, 234),
                new Ponto(0, 0),
                Corrida.calcularTempoChegadaEstimado(),
                LocalDateTime.now(),
                LocalDateTime.now().plusSeconds(Corrida.calcularTempoChegadaEstimado()),
                1,
                Corrida.calcularTempoChegadaEstimado(),
                12,
                StatusCorrida.FINALIZADA,
                1,
                5
        );

        result.add(corrida1);
        result.add(corrida2);
        result.add(corrida3);
        result.add(corrida4);

        return result;
    }
}
