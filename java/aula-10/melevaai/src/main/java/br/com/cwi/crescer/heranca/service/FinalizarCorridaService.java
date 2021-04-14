package br.com.cwi.crescer.heranca.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.heranca.domain.Motorista;
import br.com.cwi.crescer.heranca.domain.Passageiro;
import br.com.cwi.crescer.heranca.repository.MotoristaRepository;
import br.com.cwi.crescer.heranca.repository.PassageiroRepository;

@Service
public class FinalizarCorridaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Transactional // um único commit no final do método se não deu erro
    public void finalizar(Integer idMotorista, Integer idPassageiro, BigDecimal valorCorrida) {

        Motorista motorista = motoristaRepository.findById(idMotorista).get();

        Passageiro passageiro = passageiroRepository.findById(idPassageiro);

        passageiro.debitar(valorCorrida);
        passageiroRepository.save(passageiro);

        motorista.creditar(valorCorrida);
        motoristaRepository.save(motorista);
    }
}
