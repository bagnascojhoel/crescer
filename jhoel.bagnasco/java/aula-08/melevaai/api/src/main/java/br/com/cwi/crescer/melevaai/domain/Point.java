package br.com.cwi.crescer.melevaai.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class Point {

    private int x;

    private int y;

    @JsonCreator
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double measureDistance(Point destino) {
        return Math.sqrt(Math.pow((this.x-destino.x),2) + Math.pow((this.y- destino.y),2));
    }
}
