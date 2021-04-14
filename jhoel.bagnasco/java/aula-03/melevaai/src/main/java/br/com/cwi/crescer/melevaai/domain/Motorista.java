package br.com.cwi.crescer.melevaai.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(of = "cnh")
@NoArgsConstructor
@AllArgsConstructor
public class Motorista extends Pessoa {

    public static final int IDADE_MINIMA = 18;

    private CNH cnh;

    public boolean temIdadeValida() {
        return getIdade() >= IDADE_MINIMA;
    }

}
