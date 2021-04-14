package br.com.cwi.crescer.melevaai.domain;

import javax.validation.constraints.NotEmpty;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = "numero")
public class CPF {

    @NotEmpty
    private String numero;

    public CPF(String numero) {
        this.numero = numero;
    }

    public CPF() {

    }

    public String getNumero() {
        return numero;
    }
}
