import org.junit.Assert;
import org.junit.Test;

public class JutsuTest {
    @Test
    public void deveMudarOCustoParaOMaximoQuandoEleForMaiorQueOMaximo() {
        Jutsu jutsu = new Jutsu(Jutsu.CUSTO_MAXIMO + 5, 2);
        int resultadoEsperado = Jutsu.CUSTO_MAXIMO;

        int resultadoReal = jutsu.getCusto();

        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void deveMudarOCustoParaZeroQuandoEleForNegativo() {
        Jutsu jutsu = new Jutsu(-2, 1);
        int resultadoEsperado = 0;

        int resultadoReal = jutsu.getCusto();

        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void deveMudarODanoParaOMaximoQuandoEleForMaiorQueOMaximo() {
        Jutsu jutsu = new Jutsu(5, Jutsu.DANO_MAXIMO + 5);
        int resultadoEsperado = Jutsu.DANO_MAXIMO;

        int resultadoReal = jutsu.getDano();

        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void deveMudarODanoParaZeroQuandoEleForNegativo() {
        Jutsu jutsu = new Jutsu(5, -6);
        int resultadoEsperado = 0;

        int resultadoReal = jutsu.getDano();

        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }
}
