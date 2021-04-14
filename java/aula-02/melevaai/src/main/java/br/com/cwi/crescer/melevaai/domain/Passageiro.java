package br.com.cwi.crescer.melevaai.domain;

import java.time.LocalDate;

import br.com.cwi.crescer.melevaai.exceptions.IdadePassageiroInvalidaException;

public class Passageiro extends Pessoa {

    private static final int IDADE_MINIMA = 16;

    public Passageiro(String nome, String email, LocalDate dataNascimento, CPF cpf) {

        super(nome, email, dataNascimento, cpf);

        validarIdade();
    }

    private boolean isIdadeValida() {
        return super.calcularIdade() >= IDADE_MINIMA;
    }

    public void validarIdade() {

        if (!this.isIdadeValida()) {
            throw new IdadePassageiroInvalidaException();
        }
    }
}
