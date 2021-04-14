package br.com.cwi.crescer.projeto2;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

//    @GetMapping
//    public String sayHello() {
//        return "Hello World Web";
//    }

    @GetMapping
    public Pessoa qualquerCoisaPessoa() {
        return new Pessoa("Everton", LocalDate.of(1991, 7, 23));
    }
}
