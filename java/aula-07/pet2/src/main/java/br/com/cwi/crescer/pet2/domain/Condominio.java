package br.com.cwi.crescer.pet2.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Condominio {

    private int id;
    private String nome;
    private boolean aceitaPet;
    private List<Tipo> tiposPetAceitos;
}
