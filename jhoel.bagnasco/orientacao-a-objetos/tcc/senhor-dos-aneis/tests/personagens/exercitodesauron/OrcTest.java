package personagens.exercitodesauron;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrcTest {

    private Orc orc;

    @Before
    public void preparar() {
        orc = new Orc();
    }

    @Test
    public void deveTerForcaSeteQuandoConstruido() {
        int forcaEsperada = 7;

        int forcaReal = orc.getForca();

        Assert.assertEquals(forcaEsperada, forcaReal);
    }

    @Test
    public void deveTerAgilidadeQuatroQuandoConstruido() {
        int agilidadeEsperada = 4;

        int agilidadeReal = orc.getAgilidade();

        Assert.assertEquals(agilidadeEsperada, agilidadeReal);
    }

    @Test
    public void deveTerInteligenciaUmQuandoConstruido() {
        int inteligenciaEsperada = 1;

        int inteligenciaReal = orc.getInteligencia();

        Assert.assertEquals(inteligenciaEsperada, inteligenciaReal);
    }

    @Test
    public void deveTerConstituicaoTrintaQuandoConstruido() {
        int constituicaoEsperada = 30;

        int constituicaoReal = orc.getConstituicao();

        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveUsarOGrunhidoCorretoQuandoGrunir() {
        String grunhidoEsperado = "Arrrggghhh";

        String grunhidoReal = orc.grunir();

        Assert.assertEquals(grunhidoEsperado, grunhidoReal);
    }

    @Test
    public void deveSerCaracterOQuandoToString() {
        String stringEsperada = "O";

        String stringReal = orc.toString();

        Assert.assertEquals(stringEsperada, stringReal);
    }
}
