package br.com.cwi.crescer.heranca.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "z_pessoa_fisica")
public class PessoaFisica extends Pessoa {

    @Column(name = "cpf")
    private String cpf;
}
