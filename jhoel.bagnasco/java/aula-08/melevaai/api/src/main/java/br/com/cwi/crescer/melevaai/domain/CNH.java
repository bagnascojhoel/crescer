package br.com.cwi.crescer.melevaai.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@EqualsAndHashCode(of = "number")
@Table(name = "cnh")
public class CNH {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cnh_id")
    private Long id;

    @Column(name = "number")
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    @Column(name = "due_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dueDate;
}
