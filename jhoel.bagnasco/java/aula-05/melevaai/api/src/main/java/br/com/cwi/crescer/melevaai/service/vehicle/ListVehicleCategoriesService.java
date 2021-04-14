package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.domain.Categoria;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ListVehicleCategoriesService {

    public List<Categoria> list() {
        return Arrays.asList(Categoria.values());
    }
}
