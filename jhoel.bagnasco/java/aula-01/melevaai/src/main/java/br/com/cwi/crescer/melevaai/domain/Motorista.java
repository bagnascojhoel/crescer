package br.com.cwi.crescer.melevaai.domain;

import java.time.LocalDate;
import java.time.Period;

public class Motorista extends Pessoa {

    public static final int IDADE_MINIMA = 18;
    private CarteiraNacionalHabilitacao cnh;

    public Motorista(String nome, String email, LocalDate dataNascimento, CPF cpf, CarteiraNacionalHabilitacao cnh) {
        super(nome, email, dataNascimento, cpf);
        this.cnh = cnh;
    }

    public CarteiraNacionalHabilitacao getCnh() {
        return cnh;
    }

    public boolean temIdadeValida() {
        return super.getIdade() >= IDADE_MINIMA;
    }
}
