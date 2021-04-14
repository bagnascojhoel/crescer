package br.com.cwi.crescer.melevaai.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

@Getter
@NoArgsConstructor
public class Plate {

    private String number;

    @JsonCreator
    public Plate(String number) {
        this.number = number;
    }
}
