package personagens.exercitodesauron;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoblimTest {

    private Goblim goblim;

    @Before
    public void preparar() {
        goblim = new Goblim();
    }

    @Test
    public void deveTerForcaTresQuandoConstruido() {
        int forcaEsperada = 3;

        int forcaReal = goblim.getForca();

        Assert.assertEquals(forcaEsperada, forcaReal);
    }

    @Test
    public void deveTerAgilidadeSeisQuandoConstruido() {
        int agilidadeEsperada = 6;

        int agilidadeReal = goblim.getAgilidade();

        Assert.assertEquals(agilidadeEsperada, agilidadeReal);
    }

    @Test
    public void deveTerInteligenciaUmQuandoConstruido() {
        int inteligenciaEsperada = 1;

        int inteligenciaReal = goblim.getInteligencia();

        Assert.assertEquals(inteligenciaEsperada, inteligenciaReal);
    }

    @Test
    public void deveTerConstituicaoVinteQuandoConstruido() {
        int constituicaoEsperada = 20;

        int constituicaoReal = goblim.getConstituicao();

        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveUsarOGrunhidoCorretoQuandoGrunir() {
        String grunhidoEsperado = "Iiisshhhh";

        String grunhidoReal = goblim.grunir();

        Assert.assertEquals(grunhidoEsperado, grunhidoReal);
    }

    @Test
    public void deveSerCaracterMQuandoToString() {
        String stringEsperada = "M";

        String stringReal = goblim.toString();

        Assert.assertEquals(stringEsperada, stringReal);
    }
}
