package br.com.cwi.crescer.melevaai.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "number")
public class CNH {

    private String number;

    private Category category;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dueDate;
}
