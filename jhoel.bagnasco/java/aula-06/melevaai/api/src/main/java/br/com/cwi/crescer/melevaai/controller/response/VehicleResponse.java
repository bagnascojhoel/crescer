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
public class VehicleResponse {

    private Plate plate;

    private Brand brand;

    private String modelo;

    private int year;

    private Color color;

    private URL photo;

    private Category category;

    private int qtySeats;

    private Driver owner;

}
