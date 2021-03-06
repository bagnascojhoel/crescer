package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.repository.DriverRepository;
import br.com.cwi.crescer.melevaai.validators.driver.DriverWithdrawAmountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WithdrawMoneyDriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DriverWithdrawAmountValidator driverWithdrawAmountValidator;

    @Autowired
    private FetchDomainDriverByCpfService fetchDomainDriverByCpfService;

    public void withdraw(String cpf, String amount) {

        driverWithdrawAmountValidator.validate(amount);

        Driver driver = fetchDomainDriverByCpfService.fetch(cpf);

        driver.withdraw(new BigDecimal(amount));
    }
}
