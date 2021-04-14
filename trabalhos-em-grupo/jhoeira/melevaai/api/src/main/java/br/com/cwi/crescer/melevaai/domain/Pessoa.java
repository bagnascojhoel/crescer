package br.com.cwi.crescer.melevaai.domain;

import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

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

    private double carteiraVirtual;

    private double notaMedia;

    private static final int VALOR_MINIMO_DEPOSITO = 0;

    public int getIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    protected void debitar(double valor){
        if(carteiraVirtual<valor)
            throw new ValidacaoNegocioException("Valor na carteira é inferior do necessáro");
        carteiraVirtual -= valor;
    }

    protected void creditar(double valor) {
        if(valor<=VALOR_MINIMO_DEPOSITO)
            throw new ValidacaoNegocioException("Valor a ser acrescido na carteira não é maior que zero");
        carteiraVirtual += valor;
    }
}
