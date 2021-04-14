package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.controller.response.CorridaIniciarResponse;
import br.com.cwi.crescer.melevaai.domain.Corrida;
import br.com.cwi.crescer.melevaai.domain.CorridaStatus;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.service.ride.FetchRideByIdService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StartRideService {

    @Autowired
    FetchRideByIdService fetchRideByIdService;

    @Autowired ModelMapper modelMapper;

    public CorridaIniciarResponse start(String id) {

        Corrida corrida = fetchRideByIdService.fetch(Integer.parseInt(id));

        if(corrida.getStatus() != CorridaStatus.CHAMADA)
            throw new ValidacaoNegocioException("Corrida já foi iniciada.");

        corrida.setDataHoraInicio(LocalDateTime.now());
        corrida.calcValorEstimado();
        corrida.setStatus(CorridaStatus.INICIADA);

        CorridaIniciarResponse response = modelMapper.map(corrida, CorridaIniciarResponse.class);
        response.setDataHoraChegadaEstimada(LocalDateTime.now().plusSeconds(Math.round(corrida.getTempoEstimado())));

        return response;
    }
}
