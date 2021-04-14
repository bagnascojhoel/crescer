package veiculos;

import militares.Militar;
import militares.PilotoAviao;

import java.util.List;

public class Aviao extends Veiculo {

    private static final int TRIPULACAO_MAXIMA = 1;

    public Aviao(PilotoAviao piloto,
                 List<Militar> tripulacao,
                 double quilometragemPorLitro,
                 double precoPorLitroCombustivel) {

        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
    }

    @Override
    public boolean tripulacaoValida() {

        boolean licencaValida = Veiculo.licencaValida(((PilotoAviao) this.getPiloto()).getValidadeLicencaAviao());
        boolean tripulacaoNaCapacidade = this.getTripulacao().size() <= this.TRIPULACAO_MAXIMA;

        return licencaValida && tripulacaoNaCapacidade;
    }
}
