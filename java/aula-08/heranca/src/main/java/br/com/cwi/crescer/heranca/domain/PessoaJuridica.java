package br.com.cwi.crescer.heranca.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa {

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;
}
