package megazord;

import megazord.battlemode.parts.*;
import megazord.tankmode.parts.*;
import org.junit.Assert;
import org.junit.Test;
import zords.*;

import static org.junit.Assert.*;

public class MegazordTankModeTest {

    @Test
    public void deveSomarComprimentoDaRodaDireitaAoDaEsquerdaQuandoCalcularComprimento() {
        Topo topo = new PterodactylDinozord(); // c21 a10 p84 v 3087
        Centro centro = new TyrannosaurusDinozord(); // c45 a27 p96 v120
        Canhao canhao = new MastodonDinozord(); // c25 a15 p108 v120
        RodaEsquerda rodaEsquerda = new SabertoothTigerDinozord(); // c37 a13 p141 v150
        RodaDireita rodaDireita = new TriceraptopsDinozord(); // c37 a11 p141 v140
        MegazordTankMode megazordTankMode = new MegazordTankMode(
                centro,
                topo,
                canhao,
                rodaEsquerda,
                rodaDireita);
        int comprimentoEsperado = 37 + 37;

        // act
        int comprimentoReal = megazordTankMode.getComprimento();

        // assert
        Assert.assertEquals(comprimentoEsperado, comprimentoReal);
    }

    @Test
    public void deveSomarAlturaDeTodasPartesQuandoCalcularAltura() {
        Topo topo = new PterodactylDinozord(); // c21 a10 p84 v 3087
        Centro centro = new TyrannosaurusDinozord(); // c45 a27 p96 v120
        Canhao canhao = new MastodonDinozord(); // c25 a15 p108 v120
        RodaEsquerda rodaEsquerda = new SabertoothTigerDinozord(); // c37 a13 p141 v150
        RodaDireita rodaDireita = new TriceraptopsDinozord(); // c37 a11 p141 v140
        MegazordTankMode megazordTankMode = new MegazordTankMode(
                centro,
                topo,
                canhao,
                rodaEsquerda,
                rodaDireita);
        int alturaEsperada = 10 + 27 + 15 + 13 + 11;

        // act
        int alturaReal = megazordTankMode.getAltura();

        // assert
        Assert.assertEquals(alturaEsperada, alturaReal);
    }

    @Test
    public void deveSomarPesoDeTodasPartesQuandoCalcularPeso() {
        Topo topo = new PterodactylDinozord(); // c21 a10 p84 v 3087
        Centro centro = new TyrannosaurusDinozord(); // c45 a27 p96 v120
        Canhao canhao = new MastodonDinozord(); // c25 a15 p108 v120
        RodaEsquerda rodaEsquerda = new SabertoothTigerDinozord(); // c37 a13 p141 v150
        RodaDireita rodaDireita = new TriceraptopsDinozord(); // c37 a11 p141 v140
        MegazordTankMode megazordTankMode = new MegazordTankMode(
                centro,
                topo,
                canhao,
                rodaEsquerda,
                rodaDireita);
        int pesoEsperado = 84 + 96 + 108 + 141 + 141;

        // act
        int pesoReal = megazordTankMode.getPeso();

        // assert
        Assert.assertEquals(pesoEsperado, pesoReal);
    }

    @Test
    public void deveMultiplicarASomaDasVelocidadesDasRodasEsquerdaEDireitaPorDoisQuandoCalcularVelocidade() {
        Topo topo = new PterodactylDinozord(); // c21 a10 p84 v 3087
        Centro centro = new TyrannosaurusDinozord(); // c45 a27 p96 v120
        Canhao canhao = new MastodonDinozord(); // c25 a15 p108 v120
        RodaEsquerda rodaEsquerda = new SabertoothTigerDinozord(); // c37 a13 p141 v150
        RodaDireita rodaDireita = new TriceraptopsDinozord(); // c37 a11 p141 v140
        MegazordTankMode megazordTankMode = new MegazordTankMode(
                centro,
                topo,
                canhao,
                rodaEsquerda,
                rodaDireita);
        int velocidadeEsperada = (150 + 140) *2;

        // act
        int velocidadeReal = megazordTankMode.getVelocidade();

        // assert
        Assert.assertEquals(velocidadeEsperada, velocidadeReal);
    }
}