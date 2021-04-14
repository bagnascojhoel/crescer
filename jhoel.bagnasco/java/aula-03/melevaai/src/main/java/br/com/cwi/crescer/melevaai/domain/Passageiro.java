package br.com.cwi.crescer.melevaai.domain;

import br.com.cwi.crescer.melevaai.exception.PassageiroIdadeMinimaInvalidaException;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(of = "cpf")
@NoArgsConstructor
public class Passageiro extends Pessoa {

    private static final int IDADE_MINIMA = 16;

    @JsonCreator
    public Passageiro(String nome, String email, LocalDate dataNascimento, CPF cpf) {
        super(nome, email, dataNascimento, cpf);
        validarIdade();
    }

    public void validarIdade() {
        if (!temIdadeValida())
            throw new PassageiroIdadeMinimaInvalidaException();
    }

    private boolean temIdadeValida() {
        return super.getIdade() >= IDADE_MINIMA;
    }

}
