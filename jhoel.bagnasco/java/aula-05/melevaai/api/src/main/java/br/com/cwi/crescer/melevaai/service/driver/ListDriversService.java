package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListDriversService {
    @Autowired
    MotoristaRepository motoristaRepository;

    public List<Motorista> list() {
        return motoristaRepository.findAll();
    }
}
