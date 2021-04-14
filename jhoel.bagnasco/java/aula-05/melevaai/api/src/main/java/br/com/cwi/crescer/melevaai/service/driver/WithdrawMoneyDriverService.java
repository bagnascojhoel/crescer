package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import br.com.cwi.crescer.melevaai.validators.driver.DriverDoesNotExistValidator;
import br.com.cwi.crescer.melevaai.validators.driver.DriverWithdrawAmountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class WithdrawMoneyDriverService {

    @Autowired MotoristaRepository motoristaRepository;

    @Autowired DriverWithdrawAmountValidator driverWithdrawAmountValidator;

    @Autowired DriverDoesNotExistValidator driverDoesNotExistValidator;

    public void withdraw(String cpf, String amount) {

        driverWithdrawAmountValidator.validate(new BigDecimal(amount));

        Optional<Motorista> motoristaOptional = motoristaRepository.findByCpf(cpf);

        driverDoesNotExistValidator.validate(motoristaOptional);

        motoristaOptional.get().sacar(new BigDecimal(amount));
    }
}
