package br.com.cwi.crescer.melevaai.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class Motorista extends Pessoa {

    public static final int IDADE_MINIMA = 18;


    private CarteiraNacionalHabilitacao cnh;

    public Motorista(String nome, String email, LocalDate dataNascimento, CPF cpf, CarteiraNacionalHabilitacao cnh) {
        super(nome, email, dataNascimento, cpf);
        this.cnh = cnh;
    }

    private Motorista() {

    }

    @JsonIgnore
    @Override
    protected int getIdadeMinima() {
        return IDADE_MINIMA;
    }

    public CarteiraNacionalHabilitacao getCnh() {
        return cnh;
    }

}
