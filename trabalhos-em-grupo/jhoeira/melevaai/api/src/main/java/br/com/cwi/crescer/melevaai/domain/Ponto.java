package br.com.cwi.crescer.melevaai.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ponto {

    private int x;
    private int y;

    public double calcDistancia(Ponto destino) {
        return Math.sqrt(Math.pow((this.x-destino.x),2) + Math.pow((this.y- destino.y),2));
    }
}
