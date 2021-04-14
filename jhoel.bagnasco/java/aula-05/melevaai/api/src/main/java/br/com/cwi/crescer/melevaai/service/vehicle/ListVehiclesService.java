package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.domain.Veiculo;
import br.com.cwi.crescer.melevaai.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListVehiclesService {

    @Autowired VeiculoRepository veiculoRepository;

    public List<Veiculo> list() {
        return veiculoRepository.findAll();
    }
}
