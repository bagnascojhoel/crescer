package personagens.sociedadedoanel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GandalfTest {

    private Gandalf gandalf;

    @Before
    public void preparar() {
        gandalf = new Gandalf();
    }

    @Test
    public void deveTerForcaDoisQuandoConstruido() {
        int forcaEsperada = 2;

        int forcaReal = gandalf.getForca();

        Assert.assertEquals(forcaEsperada, forcaReal);
    }

    @Test
    public void deveTerAgilidadeTresQuandoConstruido() {
        int agilidadeEsperada = 3;

        int agilidadeReal = gandalf.getAgilidade();

        Assert.assertEquals(agilidadeEsperada, agilidadeReal);
    }

    @Test
    public void deveTerInteligenciaDezQuandoConstruido() {
        int inteligenciaEsperada = 10;

        int inteligenciaReal = gandalf.getInteligencia();

        Assert.assertEquals(inteligenciaEsperada, inteligenciaReal);
    }

    @Test
    public void deveTerConstituicaoOitentaQuandoConstruido() {
        int constituicaoEsperada = 80;

        int constituicaoReal = gandalf.getConstituicao();

        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveUsarAFalaCorretaQuandoFalar() {
        String falaEsperada = "A Wizard is never late, nor is he early. He arrives precisely when he means to.";

        String falaReal = gandalf.falar();

        Assert.assertEquals(falaEsperada, falaReal);
    }

    @Test
    public void deveSerCaracterGQuandoToString() {
        String stringEsperada = "G";

        String stringReal = gandalf.toString();

        Assert.assertEquals(stringEsperada, stringReal);
    }

    @Test
    public void deveUsarProprioGandalfQuandoRessucitarComConstituicaoMaiorQueZero() {
        Gandalf gandalfEsperado = gandalf;

        Gandalf gandalfReal = gandalf.ressucitar();

        Assert.assertSame(gandalfEsperado, gandalfReal);
    }

    @Test
    public void deveConstruirUmNovoGandalfQuandoRessucitarEEstiverComConstituicaoZero() {
        gandalf.receberDano(gandalf.getConstituicao());
        Gandalf novoGandalf = gandalf.ressucitar();

        Assert.assertNotSame(novoGandalf, gandalf);
    }
}
