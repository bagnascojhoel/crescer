package armas;

import locais.Posicao;
import org.junit.Assert;
import org.junit.Test;

public class ManoplaDoInfinitoTest {
    @Test
    public void deveRetornarDanoBaseQuandoCalcularDano() {
        ManoplaDoInfinito manopla = new ManoplaDoInfinito();
        int resultadoEsperado = manopla.getDanoBase();

        // act
        Posicao pos = new Posicao(1, 1);
        int resultadoReal = manopla.calcularDano(pos, pos);

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }
}
