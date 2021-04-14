package br.com.cwi.crescer.heranca.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "mla_cnh")
@SequenceGenerator(name = "mla_seq_cnh", sequenceName = "mla_seq_cnh", allocationSize = 1)
public class CNH {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mla_seq_cnh")
    private Integer id;

    @Column(name = "numero")
    private String numero;
}
