package br.com.cwi.crescer.melevaai.validator;

import static java.util.Objects.isNull;
import static org.apache.commons.lang.StringUtils.isBlank;

import org.springframework.stereotype.Component;

import br.com.cwi.crescer.melevaai.controller.request.MotoristaRequest;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;

@Component
public class MotoristaRequestValidator {

    public void accept(MotoristaRequest request) {

        if (isNull(request)) {
            throw new ValidacaoNegocioException("Request nula.");
        }

        if (isNull(request.getCnh())) {
            throw new ValidacaoNegocioException("CNH nula.");
        }

        if (isBlank(request.getCnh().getNumero())) {
            throw new ValidacaoNegocioException("Número CNH nulo ou vazio.");
        }

        if (isNull(request.getCnh().getDataVencimento())) {
            throw new ValidacaoNegocioException("Data de vencimento CNH nula.");
        }

        if (isNull(request.getCnh().getCategoria())) {
            throw new ValidacaoNegocioException("Categoria nula.");
        }

        if (isBlank(request.getNome())) {
            throw new ValidacaoNegocioException("Nome nulo ou vazio.");
        }

        if (isNull(request.getDataNascimento())) {
            throw new ValidacaoNegocioException("Data de nascimento nulo.");
        }

        //CpfValidator - retorna um boolean
        if (isBlank(request.getCpf())) {
            throw new ValidacaoNegocioException("CPF nulo ou vazio.");
        }

        if (isBlank(request.getEmail())) {
            throw new ValidacaoNegocioException("E-mail nulo ou vazio.");
        }
    }
}
