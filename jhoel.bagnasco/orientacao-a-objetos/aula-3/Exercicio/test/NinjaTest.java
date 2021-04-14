import org.junit.Assert;
import org.junit.Test;

public class NinjaTest {
    @Test
    public void deveReduzirOChakraQuandoAtacar() {
        Jutsu jutsu = new Jutsu(3, 10);
        Ninja ninjaQueAtaca = new Ninja("Jhoel, primeiro de seu nome", jutsu);

        Ninja ninjaAlvo = new Ninja("Algum nome", jutsu);

        int resultadoEsperado = ninjaQueAtaca.getChakra() - jutsu.getCusto();

        // act
        ninjaQueAtaca.atacar(ninjaAlvo);
        int resultadoReal = ninjaQueAtaca.getChakra();

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }

}
