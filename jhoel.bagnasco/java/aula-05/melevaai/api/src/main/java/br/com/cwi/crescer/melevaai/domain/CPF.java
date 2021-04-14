package br.com.cwi.crescer.melevaai.domain;

import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@EqualsAndHashCode(of = "numero")
@AllArgsConstructor
@NoArgsConstructor
public class CPF {

    private String numero;

}
