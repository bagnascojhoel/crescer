package personagens.exercitodesauron;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UrukhaiTest {

    private Urukhai urukhai;

    @Before
    public void preparar() {
        urukhai = new Urukhai();
    }

    @Test
    public void deveTerForcaOitoQuandoConstruido() {
        int forcaEsperada = 8;

        int forcaReal = urukhai.getForca();

        Assert.assertEquals(forcaEsperada, forcaReal);
    }

    @Test
    public void deveTerAgilidadeSeisQuandoConstruido() {
        int agilidadeEsperada = 6;

        int agilidadeReal = urukhai.getAgilidade();

        Assert.assertEquals(agilidadeEsperada, agilidadeReal);
    }

    @Test
    public void deveTerInteligenciaTresQuandoConstruido() {
        int inteligenciaEsperada = 3;

        int inteligenciaReal = urukhai.getInteligencia();

        Assert.assertEquals(inteligenciaEsperada, inteligenciaReal);
    }

    @Test
    public void deveTerConstituicaoQuarentaECincoQuandoConstruido() {
        int constituicaoEsperada = 45;

        int constituicaoReal = urukhai.getConstituicao();

        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveUsarOGrunhidoCorretoQuandoGrunir() {
        String grunhidoEsperado = "Uuurrrrrr";

        String grunhidoReal = urukhai.grunir();

        Assert.assertEquals(grunhidoEsperado, grunhidoReal);
    }

    @Test
    public void deveUsarAFalaCorretaQuandoFalar() {
        String falaEsperada = "Looks like meat's back on the menu boys!";

        String falaReal = urukhai.falar();

        Assert.assertEquals(falaEsperada, falaReal);
    }

    @Test
    public void deveSerCaracterUQuandoToString() {
        String stringEsperada = "U";

        String stringReal = urukhai.toString();

        Assert.assertEquals(stringEsperada, stringReal);
    }

    @Test
    public void deveReceberDoisDeDanoQuandoEnvelhecer() {
        int constituicaoEsperada = urukhai.getConstituicao() - 2;

        // act
        urukhai.envelhecer();
        int constituicaoReal = urukhai.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }
}
