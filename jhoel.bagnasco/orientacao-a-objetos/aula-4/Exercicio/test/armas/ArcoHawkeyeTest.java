package armas;

import locais.Posicao;
import org.junit.Assert;
import org.junit.Test;

public class ArcoHawkeyeTest {
    @Test
    public void deveRetornarZeroQuandoDistanciaMenorQue100() {
        ArcoHawkeye arcoHawkeye = new ArcoHawkeye();

        Posicao origem = new Posicao(0,0);
        Posicao destino = new Posicao(5, 5);
        int resultadoEsperado = 0;

        // act
        int resultadoReal = arcoHawkeye.calcularDano(origem, destino);

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void deveRetornarDanoComBonusDeDistanciaQuandoDistanciaMaiorOuIgual100EMenorOuIgual500() {
        ArcoHawkeye arcoHawkeye = new ArcoHawkeye();

        Posicao origem = new Posicao(0,0);
        Posicao destino = new Posicao(250, 250);
        int danoBonus = Arma.calcularDistancia(origem, destino) / 100;
        int resultadoEsperado = arcoHawkeye.getDanoBase() * danoBonus;

        // act
        int resultadoReal = arcoHawkeye.calcularDano(origem, destino);

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
        // nao deveria testar os casos limite?
        // com a distancia resultando em 99, 100, 101, 500 e 501
    }

    @Test
    public void deveRetornarDanoMultiplicadoPor10QuandoDistanciaForMaiorQue500() {
        ArcoHawkeye arcoHawkeye = new ArcoHawkeye();

        Posicao origem = new Posicao(500,500);
        Posicao destino = new Posicao(0, 0);
        int resultadoEsperado = arcoHawkeye.getDanoBase() * 10;

        // act
        int resultadoReal = arcoHawkeye.calcularDano(origem, destino);

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }
}
