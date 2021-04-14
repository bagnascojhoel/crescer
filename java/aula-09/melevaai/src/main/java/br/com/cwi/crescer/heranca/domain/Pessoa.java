package br.com.cwi.crescer.heranca.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mla_pessoa")
@SequenceGenerator(name = "mla_seq_pessoa", sequenceName = "mla_seq_pessoa", allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mla_seq_pessoa")
    private Integer id;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride( name = "numero", column = @Column(name = "cpf"))
    })
    private CPF cpf;

    @Column(name = "nome")
    private String nome;
}
