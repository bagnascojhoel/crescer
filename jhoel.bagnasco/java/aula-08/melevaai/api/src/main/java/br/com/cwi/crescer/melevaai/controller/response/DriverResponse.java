package br.com.cwi.crescer.melevaai.controller.response;

import br.com.cwi.crescer.melevaai.domain.CNH;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverResponse {

    private String name;

    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    private String cpf;

    private CNH cnh;

    private double virtualWallet;

    private double avgScore;

}
