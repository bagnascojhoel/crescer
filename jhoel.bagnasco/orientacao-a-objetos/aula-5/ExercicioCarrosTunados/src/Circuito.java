import trajetos.Trajeto;

import java.util.ArrayList;
import java.util.List;

public class Circuito {

    private List<Trajeto> pista;

    public Circuito(List<Trajeto> pista) {
        this.pista = pista;
    }

    public List<Carro> realizarCorrida(List<Carro> grid) {

        List<Carro> carrosQueConcluiram = new ArrayList<>();
        for (Carro carroAtual : grid)
            if (carroAtual.correr(this.pista))
                carrosQueConcluiram.add(carroAtual);

        return carrosQueConcluiram;
    }
}
