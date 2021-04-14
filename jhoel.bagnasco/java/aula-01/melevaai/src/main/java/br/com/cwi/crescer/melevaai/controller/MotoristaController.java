package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.domain.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class MotoristaController {

    @GetMapping("/motorista")
    public Motorista mostrarMotorista() {
        return new Motorista(
          "Jonas",
          "jonas.fonseca@gmail.com",
            LocalDate.now(),
            new CPF("055.892.142-12"),
            new CarteiraNacionalHabilitacao(
                    "132413241A",
                    Categoria.ACC,
                    LocalDate.now().plusYears(5)
            )
        );
    }
}
