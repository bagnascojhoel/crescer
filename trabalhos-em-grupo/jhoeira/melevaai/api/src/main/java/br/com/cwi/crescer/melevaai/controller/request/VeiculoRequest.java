package br.com.cwi.crescer.melevaai.controller.request;

import br.com.cwi.crescer.melevaai.domain.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoRequest {

    @NotNull(message = "A placa não pode ser vazia.")
    private Placa placa;

    @NotNull(message = "A marca não pode ser vazia.")
    private Marca marca;

    @NotEmpty(message = "O modelo não pode ser vazio.")
    private String modelo;

    private int ano;

    @NotNull(message = "A cor não pode ser vazia.")
    private Cor cor;

    private URL foto;

    @NotNull(message = "A categoria não pode ser vazia.")
    private Categoria categoria;

    private int qtdLugares;

    @NotEmpty(message = "O CPF do proprietario não pode ser vazio.")
    private String CPFProprietario;
}
