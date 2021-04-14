package br.com.cwi.crescer.melevaai.domain;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "numero")
public class CPF {

    @NotEmpty
    @org.hibernate.validator.constraints.br.CPF(message = "CPF inválido.")
    private String numero;
}
