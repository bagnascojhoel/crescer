package br.com.cwi.crescer.melevaai.controller.response;

import br.com.cwi.crescer.melevaai.domain.Categoria;
import br.com.cwi.crescer.melevaai.domain.Cor;
import br.com.cwi.crescer.melevaai.domain.Marca;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoResponse {

    private String placa;

    private Marca marca;

    private String modelo;

    private int ano;

    private Cor cor;

    private String foto;

    private Categoria categoria;

    private int quantidadeLugares;

    private Motorista proprietario;
}
