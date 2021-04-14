package br.com.cwi.crescer.melevaai.service.passenger;

import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListPassengersService {

    @Autowired
    PassageiroRepository passageiroRepository;

    public List<Passageiro> list() {
        return passageiroRepository.findAll();
    }
}
