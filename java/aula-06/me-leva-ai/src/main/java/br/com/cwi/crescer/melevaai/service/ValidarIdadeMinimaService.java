package br.com.cwi.crescer.melevaai.service;

import org.springframework.stereotype.Service;

import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;

@Service
public class ValidarIdadeMinimaService {

    public void validar(int idadeMinima, int idade) {

        if (idade < idadeMinima) {
            throw new ValidacaoNegocioException("Não possui idade mínima.");
        }
    }
}
