package br.com.cwi.crescer.melevaai.controller.request;

import br.com.cwi.crescer.melevaai.domain.Categoria;
import br.com.cwi.crescer.melevaai.domain.Cor;
import br.com.cwi.crescer.melevaai.domain.Marca;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Setter
@Getter
public class VeiculoRequest {

    private String placa;

    @NotEmpty
    private Marca marca;

    @NotEmpty
    private String modelo;

    private int ano;

    private Cor cor;

    private String foto;

    private Categoria categoria;

    private int quantidadeLugares;

    private String cpfMotorista;

}
