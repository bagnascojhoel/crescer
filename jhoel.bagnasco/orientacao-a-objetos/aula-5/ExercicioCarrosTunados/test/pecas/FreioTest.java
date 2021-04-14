package pecas;

import org.junit.Assert;
import org.junit.Test;
import pecas.Freio;
import trajetos.Reta;
import trajetos.Trajeto;

public class FreioTest {
    @Test
    public void deveDiminuirQualidadeDaPecaQuandoUsarNoTrajeto() {
        Freio freio = new Freio(10);
        Reta reta = new Reta(10);
        int qualidadeEsperada = 0;

        int qualidadeReal = freio.usarNoTrajeto(reta);

        Assert.assertEquals(qualidadeEsperada, qualidadeReal);
    }

    @Test
    public void deveRetornarTrueQuandoQualidadeForZero() {
        Freio freio = new Freio(0);

        // act
        boolean estadoReal = freio.estaEstragada();

        // assert
        Assert.assertTrue(estadoReal);
    }
}
