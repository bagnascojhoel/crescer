package br.com.cwi.crescer.heranca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.heranca.domain.Motorista;
import br.com.cwi.crescer.heranca.exception.NaoEncontradoException;
import br.com.cwi.crescer.heranca.repository.MotoristaRepository;

@Service
public class BuscarMotoristaPorIdService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public Motorista buscar(Integer id) {

        Optional<Motorista> motoristaEncontrado = motoristaRepository.findById(id);

        if (!motoristaEncontrado.isPresent()) {
            throw new NaoEncontradoException("Motorista não encontrado");
        }

        return motoristaEncontrado.get();
    }
}
