package armas;

import locais.Posicao;
import org.junit.Assert;
import org.junit.Test;

public class ArmaTest {
    @Test
    public void deveRetornarDistanciaEuclidianaArredondadaQuandoCalcularDistancia() {
        Posicao pos1 = new Posicao(5, 3);
        Posicao pos2 = new Posicao(28, 305);
        int resultadoEsperado = 303;

        // act
        int resultadoReal = Arma.calcularDistancia(pos1, pos2);

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }
}
