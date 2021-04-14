package br.com.cwi.crescer.melevaai.validators.driver;

import br.com.cwi.crescer.melevaai.domain.CNH;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DriverCnhValidator {
    public void validate(Motorista driver) {
        if(!isValidaDueDate(driver.getCnh()))
            throw new ValidacaoNegocioException("Motorista com CNH vencida.");
    }

    private boolean isValidaDueDate(CNH cnh) {
        return cnh.getDataVencimento().isAfter(LocalDate.now());
    }
}
