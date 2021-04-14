package br.com.cwi.crescer.heranca.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "a_pessoa_fisica")
public class PessoaFisica extends Pessoa {

    @Column(name = "meu_cpf_novo")
    private String cpf;
}
