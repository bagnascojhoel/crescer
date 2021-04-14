package megazord;

import org.junit.Assert;
import org.junit.Test;
import megazord.battlemode.parts.*;
import zords.*;
import zords.Zord;

public class MegazordBattleModeTest {

    @Test
    public void deveSomarComprimentoDaPernaDireitaEEsquerdaQuandoCalcularComprimento() {
        Cabeca cabeca = new PinkCreaneNinjazord(); // c21 a15 p600 v2469
        Peito peito = new PterodactylDinozord(); // c21 a10 p84 v 3087
        Braco braco = new BlackFrogNinjazord(); // c20 a31 p2000 v120
        PernaEsquerda pernaEsquerda = new BlueWolfNinjazord(); // c33 a39 p1300 v90
        PernaDireita perndaDireita = new TriceraptopsDinozord(); // c37 a11 p141 v140
        MegazordBattleMode megazordBattleMode = new MegazordBattleMode(
            cabeca,
            peito,
            braco,
            pernaEsquerda,
            perndaDireita);
        int comprimentoEsperado = (33 + 37) /2;

        // act
        int comprimentoReal = megazordBattleMode.getComprimento();

        // assert
        Assert.assertEquals(comprimentoEsperado, comprimentoReal);
    }

    @Test
    public void deveSomarAlturaDaCabecaDoPeitoComAlturaMediaDasPernasQuandoCalcularAltura() {
        Cabeca cabeca = new PinkCreaneNinjazord(); // c21 a15 p600 v2469
        Peito peito = new PterodactylDinozord(); // c21 a10 p84 v 3087
        Braco braco = new BlackFrogNinjazord(); // c20 a31 p2000 v120
        PernaEsquerda pernaEsquerda = new BlueWolfNinjazord(); // c33 a39 p1300 v90
        PernaDireita perndaDireita = new TriceraptopsDinozord(); // c37 a11 p141 v140
        MegazordBattleMode megazordBattleMode = new MegazordBattleMode(
                cabeca,
                peito,
                braco,
                pernaEsquerda,
                perndaDireita);
        int alturaEsperada = 15 + 10 + ((39 + 11) /2);

        // act
        int alturaReal = megazordBattleMode.getAltura();

        // assert
        Assert.assertEquals(alturaEsperada, alturaReal);
    }

    @Test
    public void deveSomarOPesoDeTodasPartesQuandoCalcularPeso() {
        Cabeca cabeca = new PinkCreaneNinjazord(); // c21 a15 p600 v2469
        Peito peito = new PterodactylDinozord(); // c21 a10 p84 v 3087
        Braco braco = new BlackFrogNinjazord(); // c20 a31 p2000 v120
        PernaEsquerda pernaEsquerda = new BlueWolfNinjazord(); // c33 a39 p1300 v90
        PernaDireita perndaDireita = new TriceraptopsDinozord(); // c37 a11 p141 v140
        MegazordBattleMode megazordBattleMode = new MegazordBattleMode(
                cabeca,
                peito,
                braco,
                pernaEsquerda,
                perndaDireita);
        int pesoEsperado = 600 + 84 + 2000 + 1300 + 141;

        // act
        int pesoReal = megazordBattleMode.getPeso();

        // assert
        Assert.assertEquals(pesoEsperado, pesoReal);
    }

    @Test
    public void deveSomarVelocidadeDaPernaDireitaADaEsquerdaEDividirPorTresQuandoCalcularVelocidade() {
        Cabeca cabeca = new PinkCreaneNinjazord(); // c21 a15 p600 v2469
        Peito peito = new PterodactylDinozord(); // c21 a10 p84 v 3087
        Braco braco = new BlackFrogNinjazord(); // c20 a31 p2000 v120
        PernaEsquerda pernaEsquerda = new BlueWolfNinjazord(); // c33 a39 p1300 v90
        PernaDireita perndaDireita = new TriceraptopsDinozord(); // c37 a11 p141 v140
        MegazordBattleMode megazordBattleMode = new MegazordBattleMode(
                cabeca,
                peito,
                braco,
                pernaEsquerda,
                perndaDireita);
        int velocidadeEsperada = (90 + 140) /3;

        // act
        int velocidadeReal = megazordBattleMode.getVelocidade();

        // assert
        Assert.assertEquals(velocidadeEsperada, velocidadeReal);
    }
}