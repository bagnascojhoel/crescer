package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.Veiculo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VeiculoRepository {

    private static List<Veiculo> veiculos = new ArrayList<>();

    public Veiculo salvar(Veiculo veiculo){
        veiculos.add(veiculo);
        return veiculo;
    }

    public List<Veiculo> listar(){
        return veiculos;
    }

}
