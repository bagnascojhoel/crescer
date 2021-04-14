package br.com.cwi.crescer.projeto1;

import java.time.LocalDate;
import java.time.Period;

public class Projeto1Application {

    public static void main(String[] args) {
        System.out.println("Hello World com maven");
        System.out.println(Period.between(LocalDate.of(1991, 7, 23), LocalDate.now()).getYears());
    }
}
