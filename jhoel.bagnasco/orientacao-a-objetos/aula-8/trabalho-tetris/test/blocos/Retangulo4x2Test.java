package blocos;

import org.junit.Assert;
import org.junit.Test;

public class Retangulo4x2Test {
    @Test
    public void deveTerAlturaQuatroQuandoCriado() {
        Retangulo4x2 retangulo4x2 = new Retangulo4x2();
        int alturaEsperada = 4;

        int alturaReal = retangulo4x2.getAltura();

        Assert.assertEquals(alturaEsperada, alturaReal);
    }

    @Test
    public void deveTerLarguraDoisQuandoCriado() {
        Retangulo4x2 retangulo4x2 = new Retangulo4x2();
        int larguraEsperada = 2;

        int larguraReal = retangulo4x2.getLargura();

        Assert.assertEquals(larguraEsperada, larguraReal);
    }

    @Test
    public void deveTerAlturaDoisQuandoGirar90Graus() {
        Retangulo4x2 retangulo4x2 = new Retangulo4x2();
        int alturaEsperada = 2;

        // act
        retangulo4x2.girar90Graus();
        int alturaReal = retangulo4x2.getAltura();

        // assert
        Assert.assertEquals(alturaEsperada, alturaReal);
    }

    @Test
    public void deveTerLarguraQuatroQuandoGirar90Graus() {
        Retangulo4x2 retangulo4x2 = new Retangulo4x2();
        int larguraEsperada = 4;

        // act
        retangulo4x2.girar90Graus();
        int larguraReal = retangulo4x2.getLargura();

        // assert
        Assert.assertEquals(larguraEsperada, larguraReal);
    }

}
