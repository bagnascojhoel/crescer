package veiculos;

import militares.Militar;
import militares.Piloto;
import militares.PilotoHelicoptero;

import java.util.List;

public class Helicoptero extends Veiculo {

    private static final int TRIPULACAO_MAXIMA = 10;

    public Helicoptero(PilotoHelicoptero piloto,
                       List<Militar> tripulacao,
                       double quilometragemPorLitro,
                       double precoPorLitroCombustivel) {

        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
    }

    @Override
    public boolean tripulacaoValida() {

        boolean licencaValida = Veiculo.licencaValida(((PilotoHelicoptero) this.getPiloto()).getValidadeLicencaHelicoptero());
        boolean tripulacaoNaCapacidade = this.getTripulacao().size() <= TRIPULACAO_MAXIMA;

        return licencaValida && tripulacaoNaCapacidade;
    }
}
