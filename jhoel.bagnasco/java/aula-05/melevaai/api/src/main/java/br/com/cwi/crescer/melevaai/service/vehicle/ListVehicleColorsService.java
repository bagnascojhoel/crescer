package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.domain.Cor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ListVehicleColorsService {
    public List<Cor> list() {
        return Arrays.asList(Cor.values());
    }
}
