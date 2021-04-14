package armas;

import locais.Posicao;
import org.junit.Assert;
import org.junit.Test;

public class DragonfangTest {
    @Test
    public void deveRetornarZeroQuandoDistanciaForMaiorQue5() {
        Dragonfang dragonfang = new Dragonfang();

        Posicao origem = new Posicao(0,0);
        Posicao destino = new Posicao(10, 10);
        int resultadoEsperado = 0;

        // act
        int resultadoReal = dragonfang.calcularDano(origem, destino);

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void deveRetornar10VezesODanoQuandoDistanciaForMenorQue5() {
        Dragonfang dragonfang = new Dragonfang();

        Posicao origem = new Posicao(0,0);
        Posicao destino = new Posicao(1, 1);
        int resultadoEsperado = dragonfang.getDanoBase() * 10;

        // act
        int resultadoReal = dragonfang.calcularDano(origem, destino);

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }
}
