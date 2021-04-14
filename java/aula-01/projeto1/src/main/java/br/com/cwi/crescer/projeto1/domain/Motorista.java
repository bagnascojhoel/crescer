package br.com.cwi.crescer.projeto1.domain;

import java.time.LocalDate;

public class Motorista extends Pessoa {

    private CarteiraNacionalHabilitacao cnh;

    public Motorista(final String nome, final String email, final LocalDate dataNascimento,
        final CPF cpf, final CarteiraNacionalHabilitacao cnh) {
        super(nome, email, dataNascimento, cpf);
        this.cnh = cnh;
    }

    public CarteiraNacionalHabilitacao getCnh() {
        return cnh;
    }
}
