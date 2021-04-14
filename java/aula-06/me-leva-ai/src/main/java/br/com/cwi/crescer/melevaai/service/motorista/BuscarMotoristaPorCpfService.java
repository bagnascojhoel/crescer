package br.com.cwi.crescer.melevaai.service.motorista;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.exception.RegistroNaoEncontradoException;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;

@Service
public class BuscarMotoristaPorCpfService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public Motorista buscar(String cpf) {

        Optional<Motorista> motorista = motoristaRepository.findByCpf(cpf);

        if (!motorista.isPresent()) {
            throw new RegistroNaoEncontradoException(Motorista.class.getName());
        }

        return motorista.get();
    }
}
