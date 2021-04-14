package br.com.cwi.crescer.melevaai.service.motorista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;

@Service
public class ListarMotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public List<Motorista> listar() {

        return motoristaRepository.findAll();
    }
}
