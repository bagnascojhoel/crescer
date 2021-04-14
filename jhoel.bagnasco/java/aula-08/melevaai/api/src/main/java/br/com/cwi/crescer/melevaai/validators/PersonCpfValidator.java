package br.com.cwi.crescer.melevaai.validators;

import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import org.springframework.stereotype.Component;

@Component
public class PersonCpfValidator {

    public void validate(String cpf) {

        if (cpf.isEmpty())
            throw new BusynessLogicException("O CPF é obrigatório.");

//        final int tamanhoNumero = cpf.length();

//        if(tamanhoNumero != 11)
//            throw new ValidacaoNegocioException("O CPF tem um tamanho inválido.");
//
//        final int primeiroDigito = extrairDigito(tamanhoNumero - 2);
//        final int segundoDigito = extrairDigito(tamanhoNumero - 1);
//
//        if (primeiroDigito != calcularPrimeiroDigito() || segundoDigito != calcularSegundoDigito())
//            throw new ValidacaoNegocioException("O CPF não é valido.");
    }
//
//    private int calcularPrimeiroDigito() {
//        final int tamanhoNumero = cpf.length();
//
//        int result = 0;
//
//        for (int i = 0, j = 10; i < tamanhoNumero - 2; i++, j--)
//            result +=  extrairDigito(i) * j;
//
//        return (result * 10) % 11;
//    }
//
//    private int calcularSegundoDigito() {
//        final int tamanhoNumero = cpf.length();
//
//        int result = 0;
//        for (int i = 0, j = 11; i < tamanhoNumero - 1; i++, j--)
//            result +=  extrairDigito(i) * j;
//
//        return (result * 10) % 11;
//    }
//
//    private int extrairDigito(int posicao) {
//        return Integer.parseInt(String.valueOf(cpf.charAt(posicao)));
//    }
}
