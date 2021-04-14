package br.com.cwi.crescer.melevaai.domain;

import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@EqualsAndHashCode(of = "numero")
@AllArgsConstructor
@NoArgsConstructor
public class CPF {

    @NotEmpty(message = "O CPF não pode ser vazio.")
    private String numero;

    public void validarCPF() {
        final int tamanhoNumero = getNumero().length();

        if(tamanhoNumero!=11)
            throw new ValidacaoNegocioException("O CPF tem um tamanho inválido.");

        final int primeiroDigito = extrairDigito(tamanhoNumero - 2);
        final int segundoDigito = extrairDigito(tamanhoNumero - 1);

        if (primeiroDigito != calcularPrimeiroDigito() || segundoDigito != calcularSegundoDigito())
            throw new ValidacaoNegocioException("O CPF não é valido.");
    }

    private int calcularPrimeiroDigito() {
        final int tamanhoNumero = getNumero().length();

        int result = 0;

        for (int i = 0, j = 10; i < tamanhoNumero - 2; i++, j--)
            result +=  extrairDigito(i) * j;

        return (result * 10) % 11;
    }

    private int calcularSegundoDigito() {
        final int tamanhoNumero = getNumero().length();

        int result = 0;
        for (int i = 0, j = 11; i < tamanhoNumero - 1; i++, j--)
            result +=  extrairDigito(i) * j;

        return (result * 10) % 11;
    }

    private int extrairDigito(int posicao) {
        return Integer.parseInt(String.valueOf(getNumero().charAt(posicao)));
    }

}
