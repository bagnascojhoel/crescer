package individuos;

import armas.ArcoHawkeye;
import armas.ManoplaDoInfinito;
import armas.Mjolnir;
import armas.MjolnirTest;
import habilidades.HabilidadeEspecial;
import habilidades.Magia;
import habilidades.SemTalento;
import locais.Posicao;
import org.junit.Assert;
import org.junit.Test;

public class VingadorTest {

    @Test
    public void deveDiminuirAVidaDoAdversarioQuandoAtacar() {

        int vidaInicial = 1000;
        Mjolnir arma = new Mjolnir();
        HabilidadeEspecial semTalento = new SemTalento();
        Posicao posicao = new Posicao(5, 5);
        Vingador vingadorQueAtaca = new Vingador("Maria", vidaInicial, arma, semTalento, posicao);

        Vingador vingadorQueApanha = new Vingador("Joao", vidaInicial, arma, semTalento, posicao);

        // act
        vingadorQueAtaca.atacar(vingadorQueApanha);
        int vidaFinal = vingadorQueApanha.getVida();

        // assert
        Assert.assertTrue(vidaFinal < vidaInicial);
    }

    @Test
    public void deveNaoAtacarQuandoEstaMorto() {
        Mjolnir arma = new Mjolnir();
        HabilidadeEspecial semTalento = new SemTalento();
        Posicao posicao = new Posicao(5, 5);
        int vidaInicial = arma.calcularDano(posicao, posicao);
        Vingador vingadorLocal = new Vingador("Maria", vidaInicial, arma, semTalento, posicao);

        Vingador vingadorAdversario = new Vingador("Joao", vidaInicial, arma, semTalento, posicao);
        int resultadoEsperado = vidaInicial;

        // act
        vingadorLocal.atacar(vingadorAdversario);
        vingadorAdversario.atacar(vingadorLocal);
        int resultadoReal = vingadorLocal.getVida();

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void deveManterAVidaEmZeroQuandoSofreDanoMaiorQueSuaVida(){
        int vidaInicial = 1000;
        ManoplaDoInfinito manoplaDoInfinito = new ManoplaDoInfinito();
        HabilidadeEspecial magia = new Magia();
        Posicao posicao = new Posicao(5, 5);
        Vingador vingadorLocal = new Vingador("Maria", vidaInicial, manoplaDoInfinito, magia, posicao);

        Vingador vingadorAdversario = new Vingador("Joao", vidaInicial, manoplaDoInfinito, magia, posicao);
        int resultadoEsperado = 0;

        // act
        vingadorLocal.atacar(vingadorAdversario);
        vingadorLocal.atacar(vingadorAdversario);
        int resultadoReal = vingadorAdversario.getVida();

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }
}
