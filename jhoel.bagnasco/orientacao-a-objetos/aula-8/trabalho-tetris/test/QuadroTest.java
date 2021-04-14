import org.junit.Assert;
import org.junit.Test;

public class QuadroTest {

    @Test
    public void deveTerPontuacaoMaiorQueUmNegativoQuandoReproduzir() {
        Quadro quadro = new Quadro(20,20);

        int pontuacao = quadro.reproduzir(50);

        Assert.assertTrue(pontuacao > -1);
    }

    @Test
    public void deveTerPontuacaoIgualAUmNegativoQuandoNaoReproduzir() {
        Quadro quadro = new Quadro(20,20);

        Assert.assertTrue(quadro.getPontuacao() == -1);
    }

    @Test
    public void deveSerVerdadeiroQuandoHouverExcecaoDeOverflow() {
        Quadro quadro = new Quadro(6, 6);

        quadro.reproduzir(50);

        Assert.assertTrue(quadro.getErroOverflow());
    }

    @Test
    public void deveSerFalsoQuandoHouverExcecaoDeOverflow() {
        Quadro quadro = new Quadro(6, 6);

        quadro.reproduzir(1);

        Assert.assertFalse(quadro.getErroOverflow());
    }

}
