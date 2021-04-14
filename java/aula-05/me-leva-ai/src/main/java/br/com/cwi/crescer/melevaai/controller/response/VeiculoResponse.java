package br.com.cwi.crescer.melevaai.controller.response;

import br.com.cwi.crescer.melevaai.domain.Categoria;
import br.com.cwi.crescer.melevaai.domain.Cor;
import br.com.cwi.crescer.melevaai.domain.Marca;
import br.com.cwi.crescer.melevaai.domain.Motorista;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VeiculoResponse {

    @NotEmpty
    private String placa;

    @NotNull
    private Marca marca;

    @NotEmpty
    private String modelo;

    @NotNull
    private int ano;

    @NotNull
    private Cor cor;

    private String foto;

    private int quantidadeLugares;

    @NotNull
    private Categoria categoria;

    @Valid
    @NotNull
    private VeiculoMotoristaResponse proprietario;
}
