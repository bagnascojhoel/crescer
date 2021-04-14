package br.com.cwi.crescer.melevaai.controller.response;

import br.com.cwi.crescer.melevaai.domain.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CorridaChamarResponse {
    private int identificador;
    private Veiculo veiculo;
    private double tempoChegada;
}
