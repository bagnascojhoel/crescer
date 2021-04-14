package br.com.cwi.crescer.melevaai.domain;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, of = {})
@ToString(callSuper = true)
public class Motorista extends Pessoa {

    public static final int IDADE_MINIMA = 18;

    private CarteiraNacionalHabilitacao cnh;

    private boolean ocupado;

    public Motorista(String nomeCompleto, String email, LocalDate dataNascimento, CPF cpf,
        CarteiraNacionalHabilitacao cnh) {
        super(nomeCompleto, email, dataNascimento, cpf);
        this.cnh = cnh;
    }
}
