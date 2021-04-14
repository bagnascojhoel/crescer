package br.com.cwi.crescer.melevaai.validator;

import org.springframework.stereotype.Component;

@Component
public class ValidarIdade {

    public boolean validarMaiorIdade(int idade, int idadeMinima){
        return idade >= idadeMinima;
    }

}
