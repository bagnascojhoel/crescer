package br.com.cwi.crescer.projeto1;

import br.com.cwi.crescer.projeto1.domain.CPF;
import br.com.cwi.crescer.projeto1.domain.CarteiraNacionalHabilitacao;
import br.com.cwi.crescer.projeto1.domain.Categoria;
import br.com.cwi.crescer.projeto1.domain.Motorista;

import java.time.LocalDate;

public class Projeto1Application {

    private static Motorista motorista;
    private static CarteiraNacionalHabilitacao cnh;

    public static void main(String[] args) {
        System.out.println("Hello world!");

        cnh = new CarteiraNacionalHabilitacao("01", Categoria.A, LocalDate.of(2018, 11, 15));
        motorista = new Motorista("Jhoel", "lasdjalfjd@gmail.com", LocalDate.of(2000, 8, 20), new CPF("000.000.000-04"), cnh);
        System.out.println(motorista.getIdade());
    }
}

