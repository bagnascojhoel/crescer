package br.com.cwi.crescer.melevaai.controller.response;

import br.com.cwi.crescer.melevaai.domain.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoResponse {

    private Placa placa;

    private Marca marca;

    private String modelo;

    private int ano;

    private Cor cor;

    private URL foto;

    private Categoria categoria;

    private int qtdLugares;

    private Motorista proprietario;

}
