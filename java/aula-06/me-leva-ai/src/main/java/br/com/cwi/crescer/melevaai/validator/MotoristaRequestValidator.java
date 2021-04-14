package br.com.cwi.crescer.melevaai.validator;

import static java.util.Objects.isNull;
import static org.apache.commons.lang.StringUtils.isBlank;

import br.com.cwi.crescer.melevaai.controller.request.CadastrarMotoristaRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;

@Component
public class MotoristaRequestValidator {

    @Autowired
    private CpfValidator cpfValidator;

    public void accept(CadastrarMotoristaRequest request) {

        if (isNull(request)) {
            throw new ValidacaoNegocioException("Request nula.");
        }

        cpfValidator.accept(request.getCpf());

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

        if (isBlank(request.getEmail())) {
            throw new ValidacaoNegocioException("E-mail nulo ou vazio.");
        }
    }
}
