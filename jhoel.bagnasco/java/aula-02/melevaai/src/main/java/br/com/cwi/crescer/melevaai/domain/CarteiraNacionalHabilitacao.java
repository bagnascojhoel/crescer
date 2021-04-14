package br.com.cwi.crescer.melevaai.domain;

import java.time.LocalDate;

public class CarteiraNacionalHabilitacao {
    private String numero;
    private Categoria categoria;
    private LocalDate dataVencimento;

    public CarteiraNacionalHabilitacao(String numero, Categoria categoria, LocalDate dataVencimento) {
        this.numero = numero;
        this.categoria = categoria;
        this.dataVencimento = dataVencimento;
    }

    public String getNumero() {
        return numero;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

}
