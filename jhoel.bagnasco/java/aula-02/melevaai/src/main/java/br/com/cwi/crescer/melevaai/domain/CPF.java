package br.com.cwi.crescer.melevaai.domain;

import br.com.cwi.crescer.melevaai.exception.CPFVazioException;

import java.util.Objects;

public class CPF {

    private String numero;

    public CPF(String numero) {
        this.numero = numero;

        validarCPFVazio();
    }

    public String getNumero() {
        return numero;
    }

    private void validarCPFVazio() {
        if (numero.equals("")) throw new CPFVazioException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CPF)) return false;
        CPF cpf = (CPF) o;
        return numero.equals(cpf.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
