package pecas;

import org.junit.Assert;
import org.junit.Test;
import trajetos.Reta;

public class MotorTest {
    @Test
    public void deveDiminuirQualidadeDaPecaQuandoUsarNoTrajeto() {
        Motor motor = new Motor(10);
        Reta reta = new Reta(10);
        int qualidadeEsperada = 0;

        int qualidadeReal = motor.usarNoTrajeto(reta);

        Assert.assertEquals(qualidadeEsperada, qualidadeReal);
    }

    @Test
    public void deveRetornarTrueQuandoQualidadeForZero() {
        Motor motor = new Motor(0);

        // act
        boolean estadoReal = motor.estaEstragada();

        // assert
        Assert.assertTrue(estadoReal);
    }
}
