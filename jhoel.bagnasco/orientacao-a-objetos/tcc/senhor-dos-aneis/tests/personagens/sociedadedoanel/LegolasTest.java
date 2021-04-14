package personagens.sociedadedoanel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LegolasTest {

    private Legolas legolas;

    @Before
    public void preparar() {
        legolas = new Legolas();
    }

    @Test
    public void deveTerForcaCincoQuandoConstruido() {
        int forcaEsperada = 5;

        int forcaReal = legolas.getForca();

        Assert.assertEquals(forcaEsperada, forcaReal);
    }

    @Test
    public void deveTerAgilidadeDezQuandoConstruido() {
        int agilidadeEsperada = 10;

        int agilidadeReal = legolas.getAgilidade();

        Assert.assertEquals(agilidadeEsperada, agilidadeReal);
    }

    @Test
    public void deveTerInteligenciaSeisQuandoConstruido() {
        int inteligenciaEsperada = 6;

        int inteligenciaReal = legolas.getInteligencia();

        Assert.assertEquals(inteligenciaEsperada, inteligenciaReal);
    }

    @Test
    public void deveTerConstituicaoOitentaQuandoConstruido() {
        int constituicaoEsperada = 80;

        int constituicaoReal = legolas.getConstituicao();

        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveUsarAFalaCorretaQuandoFalar() {
        String falaEsperada = "They're taking the Hobbits to Isengard!";

        String falaReal = legolas.falar();

        Assert.assertEquals(falaEsperada, falaReal);
    }

    @Test
    public void deveSerCaracterLQuandoToString() {
        String stringEsperada = "L";

        String stringReal = legolas.toString();

        Assert.assertEquals(stringEsperada, stringReal);
    }

    @Test
    public void deveUsarAFalaCorretaQuandoFalarElfico() {
        String falaEsperada = "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";

        String falaReal = legolas.falarElfico();

        Assert.assertEquals(falaEsperada, falaReal);
    }
}
