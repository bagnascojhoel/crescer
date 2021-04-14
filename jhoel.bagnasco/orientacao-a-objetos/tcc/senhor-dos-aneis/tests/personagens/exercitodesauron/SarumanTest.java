package personagens.exercitodesauron;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SarumanTest {

    private Saruman saruman;

    @Before
    public void preparar() {
        saruman = new Saruman();
    }

    @Test
    public void deveTerForcaDoisQuandoConstruido() {
        int forcaEsperada = 2;

        int forcaReal = saruman.getForca();

        Assert.assertEquals(forcaEsperada, forcaReal);
    }

    @Test
    public void deveTerAgilidadeDoisQuandoConstruido() {
        int agilidadeEsperada = 2;

        int agilidadeReal = saruman.getAgilidade();

        Assert.assertEquals(agilidadeEsperada, agilidadeReal);
    }

    @Test
    public void deveTerInteligenciaNoveQuandoConstruido() {
        int inteligenciaEsperada = 9;

        int inteligenciaReal = saruman.getInteligencia();

        Assert.assertEquals(inteligenciaEsperada, inteligenciaReal);
    }

    @Test
    public void deveTerConstituicaoSetentaQuandoConstruido() {
        int constituicaoEsperada = 70;

        int constituicaoReal = saruman.getConstituicao();

        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveUsarAFalaCorretaQuandoFalar() {
        String falaEsperada = "Against the power of Mordor there can be no victory.";

        String falaReal = saruman.falar();

        Assert.assertEquals(falaEsperada, falaReal);
    }

    @Test
    public void deveSerCaracterSQuandoToString() {
        String stringEsperada = "S";

        String stringReal = saruman.toString();

        Assert.assertEquals(stringEsperada, stringReal);
    }

    @Test
    public void deveSerNullQuandoRessucitar() {
        Saruman sarumanEsperado = null;

        Saruman sarumanReal = saruman.ressucitar();

        Assert.assertSame(sarumanEsperado, sarumanReal);
    }
}
