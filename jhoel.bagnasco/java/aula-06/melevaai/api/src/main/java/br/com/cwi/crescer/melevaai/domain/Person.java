package br.com.cwi.crescer.melevaai.domain;

import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Data
@EqualsAndHashCode(of = "cpf")
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {

    private static final BigDecimal MIN_DEPOSIT_AMOUNT = new BigDecimal("0");

    private String name;

    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    private String cpf;

    private BigDecimal virtualWallet;

    private double avgScore;


    public int measureAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    protected void debit(BigDecimal valor){
        if(virtualWallet.compareTo(valor) == -1)
            throw new BusynessLogicException("Valor na carteira é inferior do necessáro");

        virtualWallet.subtract(valor);
    }

    protected void credit(BigDecimal valor) {
        if(valor.compareTo(MIN_DEPOSIT_AMOUNT) < 0)
            throw new BusynessLogicException("Valor a ser acrescido na carteira não é maior que zero");

        virtualWallet.add(valor);
    }
}
