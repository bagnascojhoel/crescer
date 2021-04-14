package br.com.cwi.crescer.melevaai.controller.response;

import br.com.cwi.crescer.melevaai.domain.CNH;
import br.com.cwi.crescer.melevaai.domain.CPF;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MotoristaResponse {

    private String nome;

    private String email;

    private LocalDate dataNascimento;

    private CPF cpf;

    private CNH cnh;

}
