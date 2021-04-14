package blocos;

import org.junit.Assert;
import org.junit.Test;

public class Retangulo3x1Test {
    @Test
    public void deveTerAlturaTresQuandoCriado() {
        Retangulo3x1 retangulo3x1 = new Retangulo3x1();
        int alturaEsperada = 3;

        int alturaReal = retangulo3x1.getAltura();

        Assert.assertEquals(alturaEsperada, alturaReal);
    }

    @Test
    public void deveTerLarguraUmQuandoCriado() {
        Retangulo3x1 retangulo3x1 = new Retangulo3x1();
        int larguraEsperada = 1;

        int larguraReal = retangulo3x1.getLargura();

        Assert.assertEquals(larguraEsperada, larguraReal);
    }

    @Test
    public void deveTerAlturaUmQuandoGirar90Graus() {
        Retangulo3x1 retangulo3x1 = new Retangulo3x1();
        int alturaEsperada = 1;

        // act
        retangulo3x1.girar90Graus();
        int alturaReal = retangulo3x1.getAltura();

        // assert
        Assert.assertEquals(alturaEsperada, alturaReal);
    }

    @Test
    public void deveTerLarguraTresQuandoGirar90Graus() {
        Retangulo3x1 retangulo3x1 = new Retangulo3x1();
        int larguraEsperada = 3;

        // act
        retangulo3x1.girar90Graus();
        int larguraReal = retangulo3x1.getLargura();

        // assert
        Assert.assertEquals(larguraEsperada, larguraReal);
    }
}
