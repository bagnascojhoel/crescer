package br.com.cwi.crescer.pet2.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "condominio")
@SequenceGenerator(name = "seq_condominio", sequenceName = "seq_condominio", allocationSize = 1)
public class Condominio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_condominio")
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "aceita_pet")
    private boolean aceitaPet;

    @OneToMany(mappedBy = "condominio")
    private List<Pessoa> pessoas;

//    private List<Tipo> tiposPetAceitos;
}
