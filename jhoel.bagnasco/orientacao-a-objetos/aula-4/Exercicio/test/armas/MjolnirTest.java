package armas;

import locais.Posicao;
import org.junit.Assert;
import org.junit.Test;

public class MjolnirTest {
    @Test
    public void deveRetornarDanoBaseQuandoCalcularDano() {
        Mjolnir mjolnir = new Mjolnir();
        int resultadoEsperado = mjolnir.getDanoBase();

        // act
        Posicao pos = new Posicao(1, 1);
        int resultadoReal = mjolnir.calcularDano(pos, pos);

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }
}
