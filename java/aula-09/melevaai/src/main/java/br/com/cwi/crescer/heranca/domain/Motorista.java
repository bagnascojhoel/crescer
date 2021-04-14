package br.com.cwi.crescer.heranca.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mla_motorista")
public class Motorista extends Pessoa {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cnh")
    private CNH cnh;

    @Column(name = "endereco")
    private String endereco;
}
