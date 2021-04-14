package br.com.cwi.crescer.melevaai.service.ride;

import br.com.cwi.crescer.melevaai.domain.Corrida;
import br.com.cwi.crescer.melevaai.domain.CorridaStatus;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class FinishRideService {

    @Autowired FetchRideByIdService fetchRideByIdService;

    public void finish(String id) {
        Corrida corrida = fetchRideByIdService.fetch(Integer.parseInt(id));

        if(corrida.getStatus() == CorridaStatus.CHAMADA)
            throw new ValidacaoNegocioException("Corrida ainda não foi iniciada.");
        if(corrida.getStatus() != CorridaStatus.INICIADA)
            throw new ValidacaoNegocioException("Corrida já foi finalizada.");

        corrida.setDataHoraFim(LocalDateTime.now());

        long segundos = corrida.getDataHoraInicio().until(corrida.getDataHoraFim(), ChronoUnit.SECONDS);
        corrida.setValorReal(new BigDecimal(segundos * Corrida.VALOR_POR_SEGUNDO));

        corrida.realizarTransicoesPagamento();

        //TODO: verificar oq fazer quando a transferencia nao for realizada

        corrida.setStatus(CorridaStatus.FINALIZADA);
    }
}
