package br.com.cwi.crescer.melevaai.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(of = "numero")
@NoArgsConstructor
@AllArgsConstructor
public class CNH {

    private String numero;

    private Categoria categoria;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVencimento;

    public boolean dataCNHValida() {
        return dataVencimento.isAfter(LocalDate.now());
    }

}
