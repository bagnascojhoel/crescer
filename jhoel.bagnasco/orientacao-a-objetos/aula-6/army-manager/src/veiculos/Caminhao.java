package veiculos;

import militares.Militar;
import militares.Piloto;
import militares.PilotoCaminhao;

import java.util.List;

public class Caminhao extends Veiculo {

    private static final int TRIPULACAO_MINIMA = 5;

    private static final int TRIPULACAO_MAXIMA = 30;

    public Caminhao(PilotoCaminhao piloto,
                    List<Militar> tripulacao,
                    double quilometragemPorLitro,
                    double precoPorLitroCombustivel) {

        super(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel);
    }

    public boolean tripulacaoValida() {

        boolean licencaValida = Veiculo.licencaValida(((PilotoCaminhao) this.getPiloto()).getValidadeLicencaCaminhao());
        boolean tripulacaoNaCapacidade = (
            this.getTripulacao().size() >= TRIPULACAO_MINIMA
            && this.getTripulacao().size() <= TRIPULACAO_MAXIMA
        );

        return licencaValida && tripulacaoNaCapacidade;
    }
}
