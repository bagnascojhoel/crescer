package com.example.demo;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @ManyToMany
    @JoinTable(name="cadeira_aluno", joinColumns=
            {@JoinColumn(name="cadeira_id")}, inverseJoinColumns=
            {@JoinColumn(name="aluno_id")})
    private List<Cadeira> cadeiras;

}
