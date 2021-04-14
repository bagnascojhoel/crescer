import militares.Militar;
import militares.Piloto;
import veiculos.Veiculo;

import java.util.List;

public class SimulacaoFinanceira {

    private int distanciaDaViagem;

    private List<Veiculo> veiculos;

    private int duracaoDaMissao;

    public SimulacaoFinanceira(int distanciaDaViagem, List<Veiculo> veiculos, int duracaoDaMissao) {
        this.distanciaDaViagem = distanciaDaViagem;
        this.veiculos = veiculos;
        this.duracaoDaMissao = duracaoDaMissao;
    }

    public double getCustoTotalMissao() {

        double custoTotal = 0;
        for (Veiculo veiculo : veiculos)
            custoTotal += getCustoTripulacaoEPiloto(veiculo) + getCustoCombustivel(veiculo);

        return custoTotal;
    }

    public boolean todasTripulacoesValidas() {

        for (Veiculo veiculo : veiculos)
            if (!veiculo.tripulacaoValida())
                return false;

        return true;
    }

    private double getCustoTripulacaoEPiloto(Veiculo veiculo) {
        double salarioPiloto = ((Militar) veiculo.getPiloto()).getSalario();
        double salarioTripulacao = 0;
        for (Militar tripulante : veiculo.getTripulacao())
            salarioTripulacao += tripulante.getSalario();

        return (salarioTripulacao + salarioPiloto) * duracaoDaMissao;
    }

    private double getCustoCombustivel(Veiculo veiculo) {
        double litrosConsumidos = distanciaDaViagem / veiculo.getQuilometragemPorLitro();

        return litrosConsumidos * veiculo.getPrecoPorLitroCombustivel();
    }
}
