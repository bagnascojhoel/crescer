package veiculos;

import militares.Militar;
import militares.PilotoTanque;

import java.util.List;

public class Tanque extends Veiculo {

    private static final int TAMANHO_TRIPULACAO = 3;

    public Tanque(PilotoTanque piloto,
                  List<Militar> tripulacao,
                  double quilometragemPorLitro,
                  double precoPorLitroCombustivel) {

        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
    }

    @Override
    public boolean tripulacaoValida() {

        boolean licencaValida = Veiculo.licencaValida(((PilotoTanque) this.getPiloto()).getValidadeLicencaTanque());
        boolean tripulacaoNaCapacidade = this.getTripulacao().size() == TAMANHO_TRIPULACAO;

        return licencaValida && tripulacaoNaCapacidade;
    }
}
