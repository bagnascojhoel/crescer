package personagens.sociedadedoanel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AragornTest {

    private Aragorn aragorn;

    @Before
    public void preparar() {
        aragorn = new Aragorn();
    }

    @Test
    public void deveTerForcaDezQuandoConstruido() {
        int forcaEsperada = 10;

        int forcaReal = aragorn.getForca();

        Assert.assertEquals(forcaEsperada, forcaReal);
    }

    @Test
    public void deveTerAgilidadeSeteQuandoConstruido() {
        int agilidadeEsperada = 7;

        int agilidadeReal = aragorn.getAgilidade();

        Assert.assertEquals(agilidadeEsperada, agilidadeReal);
    }

    @Test
    public void deveTerInteligenciaSeisQuandoConstruido() {
        int inteligenciaEsperada = 6;

        int inteligenciaReal = aragorn.getInteligencia();

        Assert.assertEquals(inteligenciaEsperada, inteligenciaReal);
    }

    @Test
    public void deveTerConstituicaoSessentaQuandoConstruido() {
        int constituicaoEsperada = 60;

        int constituicaoReal = aragorn.getConstituicao();

        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveUsarAFalaCorretaQuandoFalar() {
        String falaEsperada = "A day may come when the courage of men fails… but it is not THIS day.";

        String falaReal = aragorn.falar();

        Assert.assertEquals(falaEsperada, falaReal);
    }

    @Test
    public void deveSerCaracterAQuandoToString() {
        String stringEsperada = "A";

        String stringReal = aragorn.toString();

        Assert.assertEquals(stringEsperada, stringReal);
    }

    @Test
    public void deveReceberUmDeDanoQuandoEnvelhecer() {
        int consituicaoEsperada = aragorn.getConstituicao() - 1;

        // act
        aragorn.envelhecer();
        int constituicaoReal = aragorn.getConstituicao();

        // assert
        Assert.assertEquals(consituicaoEsperada, constituicaoReal);
    }
}
