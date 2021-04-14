package pecas;

import org.junit.Assert;
import org.junit.Test;
import trajetos.Reta;

public class PneuTest {
    @Test
    public void deveDiminuirQualidadeDaPecaQuandoUsarNoTrajeto() {
        Pneu pneu = new Pneu(10);
        Reta reta = new Reta(10);
        int qualidadeEsperada = 0;

        int qualidadeReal = pneu.usarNoTrajeto(reta);

        Assert.assertEquals(qualidadeEsperada, qualidadeReal);
    }

    @Test
    public void deveRetornarTrueQuandoQualidadeForZero() {
        Pneu pneu = new Pneu(0);

        // act
        boolean estadoReal = pneu.estaEstragada();

        // assert
        Assert.assertTrue(estadoReal);
    }
}
