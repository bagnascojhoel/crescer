package blocos;

import org.junit.Assert;
import org.junit.Test;

public class Quadrado3x3Test {

    @Test
    public void deveTerAlturaTresQuandoCriado(){
        Quadrado3x3 quadrado3x3 = new Quadrado3x3();
        int alturaEsperada = 3;

        int alturaReal = quadrado3x3.getAltura();

        Assert.assertEquals(alturaEsperada, alturaReal);

    }

    @Test
    public void deveTerLarguraTresQuandoCriado(){
        Quadrado3x3 quadrado3x3 = new Quadrado3x3();
        int larguraEsperada = 3;

        int larguraReal = quadrado3x3.getLargura();

        Assert.assertEquals(larguraEsperada, larguraReal);
    }

    @Test
    public void deveManterAlturaTresQuandoGirarNoventaGraus(){
        Quadrado3x3 quadrado3x3 = new Quadrado3x3();
        int alturaEsperada = 3;

        quadrado3x3.girar90Graus();
        int alturaReal = quadrado3x3.getAltura();

        Assert.assertEquals(alturaEsperada, alturaReal);

    }

    @Test
    public void deveManterLarguraTresQuandoGirarNoventaGraus(){
        Quadrado3x3 quadrado3x3 = new Quadrado3x3();
        int larguraEsperada = 3;

        quadrado3x3.girar90Graus();
        int larguraReal = quadrado3x3.getLargura();

        Assert.assertEquals(larguraEsperada, larguraReal);
    }
}
