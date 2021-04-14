package br.com.cwi.crescer.melevaai.validators.ride;

import br.com.cwi.crescer.melevaai.domain.Corrida;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import org.springframework.stereotype.Component;

@Component
public class RideScoreValidator {

    private static final int MAX_SCORE = 5;

    private static final int MIN_SCORE = 1;

    public void validate(int score) {
        if (score < MIN_SCORE || score > MAX_SCORE) {
            throw new ValidacaoNegocioException("Essa nota não é valida.");
        }
    }
}
