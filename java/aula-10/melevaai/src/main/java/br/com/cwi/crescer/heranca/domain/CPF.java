package br.com.cwi.crescer.heranca.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class CPF {

    @Column(name = "cpf")
    private String numero;
}
