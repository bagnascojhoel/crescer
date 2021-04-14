package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.controller.request.CorridaRequest;
import br.com.cwi.crescer.melevaai.controller.response.CorridaChamarResponse;
import br.com.cwi.crescer.melevaai.controller.response.CorridaIniciarResponse;
import br.com.cwi.crescer.melevaai.domain.*;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.service.ride.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("corridas")
public class CorridaController {

    public static List<Corrida> corridaList = new ArrayList<>();

    @Autowired ModelMapper modelMapper;

    @Autowired ListOnGoingRidesService listOnGoingRidesService;

    @Autowired RequestRideService requestRideService;

    @Autowired StartRideService startRideService;

    @Autowired FinishRideService finishRideService;

    @Autowired ListRidesByCpfService listRidesByCpfService;

    @Autowired RatePassengerService ratePassengerService;

    @Autowired RateDriverService rateDriverService;

    @PostMapping("passageiros/{passengerCpf}")
    @ResponseStatus(HttpStatus.CREATED)
    public CorridaChamarResponse requestRide(
            @PathVariable String passengerCpf,
            @RequestBody @Valid CorridaRequest request) {
        return requestRideService.request(passengerCpf, request);
    }

    @GetMapping("em-andamento")
    @ResponseStatus(HttpStatus.OK)
    public List<Corrida> listOnGoingRides() {
        return listOnGoingRidesService.list();
    }

    @PostMapping("{rideId}")
    @ResponseStatus(HttpStatus.CREATED)
    public CorridaIniciarResponse startRide(@PathVariable String rideId) {
        return startRideService.start(rideId);
    }

    @PutMapping("{rideId}")
    @ResponseStatus(HttpStatus.OK)
    public void finishRide(@PathVariable String rideId) {
        finishRideService.finish(rideId);
    }

    @GetMapping("passageiros/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public List<Corrida> listarCorridas(@PathVariable String cpf) {
        return listRidesByCpfService.list(cpf);
    }

    @PostMapping("{rideId}/passageiros/avaliacao")
    @ResponseStatus(HttpStatus.OK)
    public void ratePassenger(@PathVariable String rideId, @RequestParam(name = "nota") String score) {
        ratePassengerService.rate(rideId, score);
    }

    @PostMapping("{rideId}/motoristas/avaliacao")
    @ResponseStatus(HttpStatus.OK)
    public void rateDriver(@PathVariable String rideId, @RequestParam(name = "nota") String score) {
        rateDriverService.rate(rideId, score);
    }


}
