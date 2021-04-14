package br.com.cwi.crescer.melevaai.controller.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.cwi.crescer.melevaai.domain.CarteiraNacionalHabilitacao;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class CadastrarMotoristaRequest {


    private CarteiraNacionalHabilitacao cnh;

    @NotEmpty
    private String nome;

    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String cpf;
}
