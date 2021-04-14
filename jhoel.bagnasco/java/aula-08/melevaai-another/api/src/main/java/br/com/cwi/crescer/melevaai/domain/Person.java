package br.com.cwi.crescer.melevaai.domain;

import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Data
@EqualsAndHashCode(of = "cpf")
@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

    private static final BigDecimal MIN_DEPOSIT_AMOUNT = new BigDecimal("0");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "birth_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "virtual_wallet")
    private BigDecimal virtualWallet;

    @Column(name = "avg_score")
    private Integer avgScore;

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
