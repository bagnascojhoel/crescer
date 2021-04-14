package br.com.cwi.crescer.melevaai.domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "cpf")
public abstract class Pessoa {

    @NotEmpty
    private String nome;

    @Email
    @NotEmpty(message = "Esse campo é obrigatório")
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull
    @Valid
    private CPF cpf;

    protected abstract int getIdadeMinima();

    public Pessoa(String nome, String email, LocalDate dataNascimento, CPF cpf) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    protected Pessoa() {

    }

    @JsonIgnore
    public int getIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    public void validaIdadeMinima() {

        int idadeMinima = getIdadeMinima();

        if (this.getIdade() < idadeMinima) {
            throw new ValidacaoNegocioException();
        }
    }

}