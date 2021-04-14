package br.com.cwi.crescer.melevaai.domain;

import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@EqualsAndHashCode(of = "numero")
@NoArgsConstructor
public class CPF {

    @NotEmpty(message = "O CPF não pode ser vazio.")
    private String numero;

    @JsonCreator
    public CPF(String numero) {
        this.numero = numero;

        validarCPF();
    }

    public void validarCPF() {
        final int tamanhoNumero = getNumero().length();
        final int primeiroDigito = extrairDigito(tamanhoNumero - 2);
        final int segundoDigito = extrairDigito(tamanhoNumero - 1);

        System.out.println(primeiroDigito);
        System.out.println(segundoDigito);

        System.out.println(calcularPrimeiroDigito());
        System.out.println(calcularSegundoDigito());

        if (primeiroDigito == calcularPrimeiroDigito() && segundoDigito == calcularSegundoDigito())
            throw new ValidacaoNegocioException("O CPF não é valido.");
    }

    private int calcularPrimeiroDigito() {
        final int tamanhoNumero = getNumero().length();

        int result = 0;

        for (int i = 0, j = 10; i < tamanhoNumero - 2; i++, j--)
            result +=  getNumero().charAt(i) * j;

        return (result * 10) % 11;
    }

    private int calcularSegundoDigito() {
        final int tamanhoNumero = getNumero().length();

        int result = 0;
        for (int i = 0, j = 11; i < tamanhoNumero - 1; i++, j--)
            result +=  getNumero().charAt(i) * j;

        return (result * 10) % 11;
    }

    private int extrairDigito(int posicao) {
        return Integer.parseInt(String.valueOf(getNumero().charAt(posicao)));
    }

}
