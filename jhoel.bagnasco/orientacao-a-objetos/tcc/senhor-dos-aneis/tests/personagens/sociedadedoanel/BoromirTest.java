package personagens.sociedadedoanel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoromirTest {

    private Boromir boromir;

    @Before
    public void preparar() {
        boromir = new Boromir();
    }

    @Test
    public void deveTerForcaSeteQuandoConstruido() {
        int forcaEsperada = 7;

        int forcaReal = boromir.getForca();

        Assert.assertEquals(forcaEsperada, forcaReal);
    }

    @Test
    public void deveTerAgilidadeSeisQuandoConstruido() {
        int agilidadeEsperada = 6;

        int agilidadeReal = boromir.getAgilidade();

        Assert.assertEquals(agilidadeEsperada, agilidadeReal);
    }

    @Test
    public void deveTerInteligenciaTresQuandoConstruido() {
        int inteligenciaEsperada = 3;

        int inteligenciaReal = boromir.getInteligencia();

        Assert.assertEquals(inteligenciaEsperada, inteligenciaReal);
    }

    @Test
    public void deveTerConstituicaoQuarentaQuandoConstruido() {
        int constituicaoEsperada = 40;

        int constituicaoReal = boromir.getConstituicao();

        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveUsarAFalaCorretaQuandoFalar() {
        String falaEsperada = "One does not simply walk into Mordor.";

        String falaReal = boromir.falar();

        Assert.assertEquals(falaEsperada, falaReal);
    }

    @Test
    public void deveSerCaracterBQuandoToString() {
        String stringEsperada = "B";

        String stringReal = boromir.toString();

        Assert.assertEquals(stringEsperada, stringReal);
    }

    @Test
    public void deveReceberDoisDeDanoQuandoEnvelhecer() {
        int constituicaoEsperada = boromir.getConstituicao() - 2;

        // act
        boromir.envelhecer();
        int constituicaoReal = boromir.getConstituicao();

        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }
}
