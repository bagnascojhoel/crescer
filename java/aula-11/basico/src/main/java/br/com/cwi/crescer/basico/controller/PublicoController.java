package br.com.cwi.crescer.basico.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publico")
public class PublicoController {

    @GetMapping
    public String publico() {
        return "publico";
    }

}
