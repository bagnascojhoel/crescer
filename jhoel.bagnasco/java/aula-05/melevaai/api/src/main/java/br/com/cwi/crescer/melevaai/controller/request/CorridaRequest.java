package br.com.cwi.crescer.melevaai.controller.request;

import br.com.cwi.crescer.melevaai.domain.Ponto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CorridaRequest {

    @NotNull
    private Ponto inicio;

    @NotNull
    private Ponto fim;
}
