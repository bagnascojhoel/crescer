package br.com.cwi.crescer.melevaai.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotEmpty;

public class CarteiraNacionalHabilitacao {

    @NotEmpty(message = "Você não preencheu esse campo")
    private String numero;

    private Categoria categoria;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVencimento;

    public CarteiraNacionalHabilitacao(String numero, Categoria categoria, LocalDate dataVencimento) {
        this.numero = numero;
        this.categoria = categoria;
        this.dataVencimento = dataVencimento;
    }

    private CarteiraNacionalHabilitacao() {

    }

    public Categoria getCategoria() {
        return categoria;
    }

    @JsonIgnore
    public boolean isVencida() {
        return dataVencimento.isBefore(LocalDate.now());
    }


    public String getNumero() {
        return numero;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }
}
