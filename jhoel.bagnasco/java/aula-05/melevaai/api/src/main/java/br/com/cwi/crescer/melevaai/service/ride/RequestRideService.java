package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.controller.request.CorridaRequest;
import br.com.cwi.crescer.melevaai.controller.response.CorridaChamarResponse;
import br.com.cwi.crescer.melevaai.domain.Corrida;
import br.com.cwi.crescer.melevaai.domain.CorridaStatus;
import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.repository.CorridaRepository;
import br.com.cwi.crescer.melevaai.repository.PassageiroRepository;
import br.com.cwi.crescer.melevaai.repository.VeiculoRepository;
import br.com.cwi.crescer.melevaai.service.VerifyPassengerOnRideService;
import br.com.cwi.crescer.melevaai.service.vehicle.FetchRandomVehicleService;
import br.com.cwi.crescer.melevaai.service.vehicle.ListAvailableVehiclesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RequestRideService {

    private static final int PASSO_IDENTIFICADOR = 1;

    @Autowired PassageiroRepository passageiroRepository;

    @Autowired CorridaRepository corridaRepository;

    @Autowired ModelMapper mapper;

    @Autowired
    ListAvailableVehiclesService listAvailableVehiclesService;

    @Autowired
    VerifyPassengerOnRideService verifyPassengerOnRideService;

    @Autowired
    FetchRandomVehicleService fetchRandomVehicleService;

    public CorridaChamarResponse request(String cpf, CorridaRequest request) {
        Optional<Passageiro> passageiro = passageiroRepository.findByCpf(cpf);

        if(!passageiro.isPresent())
            throw new ValidacaoNegocioException("Passageiro não listado.");

        if (verifyPassengerOnRideService.verify(cpf))
            throw new ValidacaoNegocioException("Passageiro já está em corrida.");

        if(listAvailableVehiclesService.list().isEmpty())
            throw new ValidacaoNegocioException("Sem veículos disponíveis.");

        Corrida corrida = mapRequestToCorrida(request, passageiro.get());

        corridaRepository.add(corrida);

        CorridaChamarResponse response = mapper.map(corrida, CorridaChamarResponse.class);

        return response;
    }

    private Corrida mapRequestToCorrida(CorridaRequest request, Passageiro passageiro) {
        Corrida result = mapper.map(request, Corrida.class);
        int identificador = corridaRepository.findAll().size() + PASSO_IDENTIFICADOR;

        result.setId(identificador);
        result.setTempoChegada(Corrida.calcularTempoChegadaEstimado());
        result.setPassageiro(passageiro);
        result.setVeiculo(fetchRandomVehicleService.fetch());
        result.setStatus(CorridaStatus.CHAMADA);

        return result;
    }
}
