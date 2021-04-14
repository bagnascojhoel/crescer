package br.com.cwi.crescer.melevaai.domain;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class Passageiro extends Pessoa {

    public static final int IDADE_MINIMA = 16;

    public Passageiro(String nome, String email, LocalDate dataNascimento, CPF cpf) {
        super(nome, email, dataNascimento, cpf);
    }

    private Passageiro() {

    }

    @Override
    protected int getIdadeMinima() {
        return IDADE_MINIMA;
    }
}
