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
public class VehicleRequest {

    @NotNull(message = "A placa não pode ser vazia.")
    private Plate plate;

    @NotNull(message = "A marca não pode ser vazia.")
    private Brand brand;

    @NotEmpty(message = "O modelo não pode ser vazio.")
    private String modelo;

    private int year;

    @NotNull(message = "A cor não pode ser vazia.")
    private Color color;

    private URL photo;

    @NotNull(message = "A categoria não pode ser vazia.")
    private Category category;

    private int qtySeats;

    @NotEmpty(message = "O CPF do proprietario não pode ser vazio.")
    private String ownerCpf;
}
