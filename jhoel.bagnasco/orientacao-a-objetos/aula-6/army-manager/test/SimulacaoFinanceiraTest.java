import militares.Elite;
import militares.EspecialistaDoAr;
import militares.Militar;
import militares.PilotoTanqueImpl;
import org.junit.Assert;
import org.junit.Test;
import veiculos.Aviao;
import veiculos.Caminhao;
import veiculos.Tanque;
import veiculos.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SimulacaoFinanceiraTest {
    @Test
    public void deveMultiplicarSalarioPilotosETripulatesPeloTempoMissaoSomandoCustoCombustivelQuandoCalcularCustoTotalMissao() {
        LocalDate dataValidadeValida = LocalDate.now().plusDays(1);
        double salarioPiloto = 10000;
        Elite piloto = new Elite(   // 10.000
                salarioPiloto,
                dataValidadeValida,
                dataValidadeValida,
                dataValidadeValida,
                dataValidadeValida);

        double salarioMilitar = 1000;
        List<Militar> tripulacao = new ArrayList<>();
        for (int i = 5; i > 0; i--)
            tripulacao.add(new Militar(salarioMilitar)); // 5.000

        double quilometragemPorLitro = 1;
        double precoPorLitroCombustivel = 1;
        List<Veiculo> veiculos = new ArrayList<>();
        for (int i = 5; i > 0; i--)
            veiculos.add(new Caminhao(piloto, tripulacao, quilometragemPorLitro, precoPorLitroCombustivel));

        int distanciaDaViagem = 1000;
        int duracaoDaMissao = 3;
        SimulacaoFinanceira simulacaoFinanceira = new SimulacaoFinanceira(distanciaDaViagem, veiculos, duracaoDaMissao);

        double gastoCombustivelPorVeiculo = distanciaDaViagem / quilometragemPorLitro * precoPorLitroCombustivel;
        double gastoComCombustivelTotal = gastoCombustivelPorVeiculo * veiculos.size();
        double salarioTripulacao = salarioMilitar * tripulacao.size();
        double gastoComTripulacaoPorMes = (salarioPiloto + salarioTripulacao) * veiculos.size();
        double gastoComTripulacaoTotal = gastoComTripulacaoPorMes * duracaoDaMissao;
        double custoEsperado = gastoComTripulacaoTotal + gastoComCombustivelTotal;

        // act
        double custoReal = simulacaoFinanceira.getCustoTotalMissao();

        // assert
        Assert.assertEquals(custoEsperado, custoReal, 0.01);
    }

    @Test
    public void deveRetornarVerdadeiroQuandoTodosVeiculosForemValidos() {
        LocalDate dataValidadeValida = LocalDate.now().plusDays(1);
        Elite piloto = new Elite(   // 10.000
                10,
                dataValidadeValida,
                dataValidadeValida,
                dataValidadeValida,
                dataValidadeValida);

        List<Militar> tripulacao = new ArrayList<>();
        for (int i = 5; i > 0; i--)
            tripulacao.add(new Militar(1)); // 5.000

        List<Veiculo> veiculos = new ArrayList<>();
        for (int i = 5; i > 0; i--)
            veiculos.add(new Caminhao(piloto, tripulacao, 1,1));

        SimulacaoFinanceira simulacaoFinanceira = new SimulacaoFinanceira(1, veiculos, 1);

        // act
        boolean resultado = simulacaoFinanceira.todasTripulacoesValidas();

        // assert
        Assert.assertTrue(resultado);
    }

    @Test
    public void deveRetonarFalsoQuandoAlgumVeiculoForInvalido() {
        LocalDate dataValidadeValida = LocalDate.now().plusDays(1);
        Elite piloto = new Elite(   // 10.000
                10,
                dataValidadeValida,
                dataValidadeValida,
                dataValidadeValida,
                dataValidadeValida);

        List<Militar> tripulacao = new ArrayList<>();
        for (int i = 5; i > 0; i--)
            tripulacao.add(new Militar(1)); // 5.000

        List<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(new Caminhao(piloto, tripulacao, 1,1));
        veiculos.add(new Tanque(piloto, tripulacao, 1,1)); // isso fara retornar false
        veiculos.add(new Caminhao(piloto, tripulacao, 1,1));

        SimulacaoFinanceira simulacaoFinanceira = new SimulacaoFinanceira(1, veiculos, 1);

        // act
        boolean resultado = simulacaoFinanceira.todasTripulacoesValidas();

        // assert
        Assert.assertFalse(resultado);
    }


    @Test
    public void testeBase1() {

        List<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(criarAviao());
        veiculos.add(criarTanque());
        veiculos.add(criarTanque());
        veiculos.add(criarTanque());
        veiculos.add(criarTanque());
        veiculos.add(criarTanque());

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1137, veiculos, 1);

        double custoTotal = simulacao.getCustoTotalMissao();

        Assert.assertEquals(213623.81, custoTotal, 0.1);
        Assert.assertFalse(simulacao.todasTripulacoesValidas());
    }

    private Tanque criarTanque() {

        Elite piloto = new Elite(3000,
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(20));

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new PilotoTanqueImpl(2500, LocalDate.now().minusYears(1)));
        tripulacao.add(new Militar(600));
        tripulacao.add(new Militar(600));

        return new Tanque(piloto, tripulacao, 0.22, 3.46);
    }

    private Aviao criarAviao() {

        EspecialistaDoAr piloto = new EspecialistaDoAr(7000, LocalDate.now().plusDays(-20), LocalDate.now().plusDays(20));

        ArrayList<Militar> tripulacao = new ArrayList<>();

        tripulacao.add(new Militar(2500));

        return new Aviao(piloto, tripulacao, 0.14, 10);
    }

}
