package br.com.cwi.crescer.melevaai.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode(of = "cpf")
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pessoa {

    private String nome;

    private String email;

    private LocalDate dataNascimento;

    private CPF cpf;

    public int getIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

}
