import org.junit.Assert;
import org.junit.Test;

public class BatalhaTest {
    @Test
    public void deveRetornarItachiComoVencedorQuandoReceberUmNinjaComNomeItachi() {
        Jutsu justuMaisFraco = new Jutsu(5, 1);
        Ninja itachi = new Ninja("Itachi", justuMaisFraco);

        Jutsu justuMaisForte = new Jutsu(1, 10);
        Ninja outroNinjaQualquer = new Ninja("OutroNinja", justuMaisForte);


        Ninja resultadoEsperado = itachi;

        // act
        Batalha batalha = new Batalha();
        Ninja resultadoReal = batalha.lutar(itachi, outroNinjaQualquer);

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void deveRetornarNinjaComMaisChakraAposLutaQuandoJutsuDeAlgumNinjaForMaisPoderoso() {
        Jutsu justoMaisPoderoso = new Jutsu(1, 10);
        Ninja narutoDoShippuden = new Ninja("Naruto do Shippuden", justoMaisPoderoso);

        Jutsu jutsoMaisFraco = new Jutsu(5, 1);
        Ninja narutoDoClassico = new Ninja("Naruto do Classico", jutsoMaisFraco);

        Ninja resultadoEsperado = narutoDoShippuden;

        // act
        Batalha batalha = new Batalha();
        Ninja resultadoReal = batalha.lutar(narutoDoClassico, narutoDoShippuden);

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void deveRetornarNinjaLocalQuandoALutaEmpatar() {
        Jutsu justu = new Jutsu(1, 10);
        Ninja ninjaLocal = new Ninja("Naruto do Shippuden", justu);

        Ninja ninjaDesafiante = new Ninja("Naruto do Classico", justu);
        Ninja resultadoEsperado = ninjaLocal;

        // act
        Batalha batalha = new Batalha();
        Ninja resultadoReal = batalha.lutar(ninjaLocal, ninjaDesafiante);

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }

}
