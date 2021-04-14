package br.com.cwi.crescer.melevaai.domain;

import java.time.LocalDate;
import java.time.Period;

public abstract class Pessoa {

    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private CPF cpf;

    public Pessoa(String nome, String email, LocalDate dataNascimento, CPF cpf) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public CPF getCpf() {
        return cpf;
    }

    public int getIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }
}
