package blocos;

import org.junit.Assert;
import org.junit.Test;

public class Quadrado2x2Test {

    @Test
    public void deveTerAlturaDoisQuandoCriado(){
        Quadrado2x2 quadrado2x2 = new Quadrado2x2();
        int alturaEsperada = 2;

        int alturaReal = quadrado2x2.getAltura();

        Assert.assertEquals(alturaEsperada, alturaReal);

    }

    @Test
    public void deveTerLarguraDoisQuandoCriado(){
        Quadrado2x2 quadrado2x2 = new Quadrado2x2();
        int larguraEsperada = 2;

        int larguraReal = quadrado2x2.getLargura();

        Assert.assertEquals(larguraEsperada, larguraReal);
    }

    @Test
    public void deveManterAlturaDoisQuandoGirarNoventaGraus(){
        Quadrado2x2 quadrado2x2 = new Quadrado2x2();
        int alturaEsperada = 2;

        quadrado2x2.girar90Graus();
        int alturaReal = quadrado2x2.getAltura();

        Assert.assertEquals(alturaEsperada, alturaReal);

    }

    @Test
    public void deveManterLarguraDoisQuandoGirarNoventaGraus(){
        Quadrado2x2 quadrado2x2 = new Quadrado2x2();
        int larguraEsperada = 2;

        quadrado2x2.girar90Graus();
        int larguraReal = quadrado2x2.getLargura();

        Assert.assertEquals(larguraEsperada, larguraReal);
    }
}
