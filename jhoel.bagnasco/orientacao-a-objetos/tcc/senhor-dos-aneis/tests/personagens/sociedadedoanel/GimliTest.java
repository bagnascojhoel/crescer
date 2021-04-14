package personagens.sociedadedoanel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GimliTest {

    private Gimli gimli;

    @Before
    public void preparar() {
        gimli = new Gimli();
    }

    @Test
    public void deveTerForcaNoveQuandoConstruido() {
        int forcaEsperada = 9;

        int forcaReal = gimli.getForca();

        Assert.assertEquals(forcaEsperada, forcaReal);
    }

    @Test
    public void deveTerAgilidadeDoisQuandoConstruido() {
        int agilidadeEsperada = 2;

        int agilidadeReal = gimli.getAgilidade();

        Assert.assertEquals(agilidadeEsperada, agilidadeReal);
    }

    @Test
    public void deveTerInteligenciaQuatroQuandoConstruido() {
        int inteligenciaEsperada = 4;

        int inteligenciaReal = gimli.getInteligencia();

        Assert.assertEquals(inteligenciaEsperada, inteligenciaReal);
    }

    @Test
    public void deveTerConstituicaoSessentaQuandoConstruido() {
        int constituicaoEsperada = 60;

        int constituicaoReal = gimli.getConstituicao();

        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveSerCaracterIQuandoToString() {
        String stringEsperada = "I";

        String stringReal = gimli.toString();

        Assert.assertEquals(stringEsperada, stringReal);
    }

    @Test
    public void deveUsarFalaDeSobrioQuandoFalarComSobriedadeMaiorQueZero() {
        String falaEsperada = "Let them come. There is one Dwarf yet in Moria who still draws breath.";

        // act
        String falaReal = gimli.falar();

        // assert
        Assert.assertEquals(falaEsperada, falaReal);
    }


    @Test
    public void deveUsarFalaDeBebadoQuandoFalarAposBeberTresVezes() {
        String falaEsperada = "What did I say? He can't hold his liquor!";

        // act
        gimli.beber();
        gimli.beber();
        gimli.beber();

        String falaReal = gimli.falar();

        // assert
        Assert.assertEquals(falaEsperada, falaReal);
    }


    @Test
    public void deveDiminuirUmPontoDeSobriedadeQuandoBeber() {
        int sobriedadeEsperada = gimli.getSobriedade() - 1;

        // act
        gimli.beber();
        int sobriedadeReal = gimli.getSobriedade();

        // assert
        Assert.assertEquals(sobriedadeEsperada, sobriedadeReal);
    }

}
