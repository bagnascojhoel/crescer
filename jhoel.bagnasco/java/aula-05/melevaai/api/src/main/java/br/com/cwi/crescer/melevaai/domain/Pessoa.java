package br.com.cwi.crescer.melevaai.domain;

import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@EqualsAndHashCode(of = "cpf")
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pessoa {

    private String nome;

    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private CPF cpf;

    private BigDecimal carteiraVirtual;

    private double notaMedia;

    private static final BigDecimal VALOR_MINIMO_DEPOSITO = new BigDecimal("0");

    public int getIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    protected void debitar(BigDecimal valor){
        if(carteiraVirtual.compareTo(valor) == -1)
            throw new ValidacaoNegocioException("Valor na carteira é inferior do necessáro");

        carteiraVirtual.subtract(valor);
    }

    protected void creditar(BigDecimal valor) {
        if(valor.compareTo(VALOR_MINIMO_DEPOSITO) < 0)
            throw new ValidacaoNegocioException("Valor a ser acrescido na carteira não é maior que zero");

        carteiraVirtual.add(valor);
    }
}
