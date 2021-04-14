package br.com.cwi.crescer.melevaai.service.passenger;

import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.repository.PassageiroRepository;
import br.com.cwi.crescer.melevaai.validators.passenger.PassengerDepositAmountValidator;
import br.com.cwi.crescer.melevaai.validators.passenger.PassengerDoesNotExistValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class DepositMoneyPassengerService {

    @Autowired
    PassengerDepositAmountValidator passengerDepositAmountValidator;

    @Autowired
    PassageiroRepository passageiroRepository;

    @Autowired
    PassengerDoesNotExistValidator passengerDoesNotExistValidator;

    public void deposit(String cpf, String amount) {

        passengerDepositAmountValidator.validate(new BigDecimal(amount));

        Optional<Passageiro> passageiroOptional = passageiroRepository.findByCpf(cpf);

        passengerDoesNotExistValidator.validate(passageiroOptional);

        Passageiro passageiro = passageiroOptional.get();

        passageiro.depositar(new BigDecimal(amount));
    }
}
