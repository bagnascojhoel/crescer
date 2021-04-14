package veiculos;

import militares.Militar;
import militares.Piloto;

import java.time.LocalDate;
import java.util.List;

public abstract class Veiculo {

    private Piloto piloto;

    private List<Militar> tripulacao;

    private double quilometragemPorLitro;

    private double precoPorLitroCombustivel;

    public Veiculo(Piloto piloto, List<Militar> tripulacao, double quilometragemPorLitro, double precoPorLitroCombustivel) {
        this.piloto = piloto;
        this.tripulacao = tripulacao;
        this.quilometragemPorLitro = quilometragemPorLitro;
        this.precoPorLitroCombustivel = precoPorLitroCombustivel;
    }

    public abstract boolean tripulacaoValida();

    public static boolean licencaValida(LocalDate validadeLicenca) {

        int resultadoComparacao = LocalDate.now().compareTo(validadeLicenca);

        if (resultadoComparacao >= 0)
            return false;
        else
            return true;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public List<Militar> getTripulacao() {
        return tripulacao;
    }

    public double getQuilometragemPorLitro() {
        return quilometragemPorLitro;
    }

    public double getPrecoPorLitroCombustivel() {
        return precoPorLitroCombustivel;
    }

}
