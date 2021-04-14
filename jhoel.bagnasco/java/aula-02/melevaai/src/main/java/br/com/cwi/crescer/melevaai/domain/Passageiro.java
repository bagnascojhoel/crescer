package br.com.cwi.crescer.melevaai.domain;

import br.com.cwi.crescer.melevaai.exception.PassageiroIdadeMinimaInvalidaException;

import java.time.LocalDate;

public class Passageiro extends Pessoa {

    private static final int IDADE_MINIMA = 16;

    public Passageiro(String nome, String email, LocalDate dataNascimento, CPF cpf) {
        super(nome, email, dataNascimento, cpf);
        validarIdade();
    }

    private boolean temIdadeValida() {
        return super.getIdade() >= IDADE_MINIMA;
    }

    public void validarIdade() {
        if (!temIdadeValida())
            throw new PassageiroIdadeMinimaInvalidaException();
    }

}
