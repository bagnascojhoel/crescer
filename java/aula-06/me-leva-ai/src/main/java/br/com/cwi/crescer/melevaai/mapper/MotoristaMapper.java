package br.com.cwi.crescer.melevaai.mapper;

import org.springframework.stereotype.Component;

import br.com.cwi.crescer.melevaai.controller.request.CadastrarMotoristaRequest;
import br.com.cwi.crescer.melevaai.domain.CPF;
import br.com.cwi.crescer.melevaai.domain.Motorista;

@Component
public class MotoristaMapper {

    public Motorista converter(CadastrarMotoristaRequest request) {

        CPF cpf = new CPF(request.getCpf());

        return new Motorista(request.getNome(),
            request.getEmail(),
            request.getDataNascimento(),
            cpf,
            request.getCnh());
    }
}
