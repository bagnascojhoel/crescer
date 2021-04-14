package br.com.cwi.crescer.melevaai.validator;

import static org.apache.commons.lang.StringUtils.isBlank;

import org.springframework.stereotype.Component;

import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;

@Component
public class CpfValidator {

    public void accept(String cpf) {

        //TODO validacao CPF

        if (isBlank(cpf)) {
            throw new ValidacaoNegocioException("CPF inválido.");
        }

    }
}
