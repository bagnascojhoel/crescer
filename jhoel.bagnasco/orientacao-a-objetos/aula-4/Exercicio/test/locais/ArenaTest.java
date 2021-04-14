package locais;

import armas.ArcoHawkeye;
import armas.Mjolnir;
import habilidades.HabilidadeEspecial;
import habilidades.SemTalento;
import individuos.Vingador;
import org.junit.Assert;
import org.junit.Test;

public class ArenaTest {
    @Test
    public void deveVencerQuandoOAdversarioEstaForaDaArenaNaLargura() {
        Arena arena = new Arena(10, 10);

        ArcoHawkeye arcoHawkeye = new ArcoHawkeye();
        HabilidadeEspecial semTalento = new SemTalento();
        Posicao posicaoDentro = new Posicao(2,3);
        Vingador vingadorDentroDaArena = new Vingador("Maria", 100, arcoHawkeye, semTalento, posicaoDentro);


        Posicao posicaoFora = new Posicao(0, 3);
        Vingador vingadorForaDaArena = new Vingador("Joao", 100, arcoHawkeye, semTalento, posicaoFora);

        String resultadoEsperado = vingadorDentroDaArena.getNome();

        // act
        String resultadoReal = arena.batalhar(vingadorDentroDaArena, vingadorForaDaArena);

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void deveVencerQuandoOAdversarioEstaForaDaArenaNaProfundidade() {
        Arena arena = new Arena(10, 10);

        ArcoHawkeye arcoHawkeye = new ArcoHawkeye();
        HabilidadeEspecial semTalento = new SemTalento();
        Posicao posicaoDentro = new Posicao(2,3);
        Vingador vingadorDentroDaArena = new Vingador("Maria", 100, arcoHawkeye, semTalento, posicaoDentro);


        Posicao posicaoFora = new Posicao(5, 0);
        Vingador vingadorForaDaArena = new Vingador("Joao", 100, arcoHawkeye, semTalento, posicaoFora);

        String resultadoEsperado = vingadorDentroDaArena.getNome();

        // act
        String resultadoReal = arena.batalhar(vingadorDentroDaArena, vingadorForaDaArena);

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void devePerderQuandoEstaForaDaArenaNaLargura() {
        Arena arena = new Arena(10, 10);

        ArcoHawkeye arcoHawkeye = new ArcoHawkeye();
        HabilidadeEspecial semTalento = new SemTalento();
        Posicao posicaoDentro = new Posicao(2,3);
        Vingador vingadorDentroDaArena = new Vingador("Maria", 100, arcoHawkeye, semTalento, posicaoDentro);

        Posicao posicaoFora = new Posicao(11, 3);
        Vingador vingadorForaDaArena = new Vingador("Joao", 100, arcoHawkeye, semTalento, posicaoFora);

        String resultadoEsperado = vingadorDentroDaArena.getNome();

        // act
        String resultadoReal = arena.batalhar(vingadorForaDaArena, vingadorDentroDaArena);

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void devePerderQuandoEstaForaDaArenaNaProfundidade() {
        Arena arena = new Arena(10, 10);

        ArcoHawkeye arcoHawkeye = new ArcoHawkeye();
        HabilidadeEspecial semTalento = new SemTalento();
        Posicao posicaoDentro = new Posicao(2,3);
        Vingador vingadorDentroDaArena = new Vingador("Maria", 100, arcoHawkeye, semTalento, posicaoDentro);

        Posicao posicaoFora = new Posicao(5, 11);
        Vingador vingadorForaDaArena = new Vingador("Joao", 100, arcoHawkeye, semTalento, posicaoFora);

        String resultadoEsperado = vingadorDentroDaArena.getNome();

        // act
        String resultadoReal = arena.batalhar(vingadorForaDaArena, vingadorDentroDaArena);

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void deveEmpatarQuandoOsDoisVingadoresEstaoForaDaArena() {
        Arena arena = new Arena(10, 10);

        ArcoHawkeye arcoHawkeye = new ArcoHawkeye();
        HabilidadeEspecial semTalento = new SemTalento();
        Posicao posicaoFora = new Posicao(5, 11);
        Vingador vingadorUm = new Vingador("Maria",100, arcoHawkeye, semTalento, posicaoFora);
        Vingador vingadorDois = new Vingador("Joao",100, arcoHawkeye, semTalento, posicaoFora);

        String resultadoEsperado = "EMPATE";

        // act
        String resultadoReal = arena.batalhar(vingadorDois, vingadorUm);

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void deveEmpatarQuandoOsDoisVingadoresEstiveremComVidaIgual() {
        Arena arena = new Arena(10, 10);

        Mjolnir mjolnir = new Mjolnir();
        HabilidadeEspecial semTalento = new SemTalento();
        Posicao posicaoDentro = new Posicao(5, 5);
        Vingador vingadorLocal = new Vingador("Maria",100, mjolnir, semTalento, posicaoDentro);
        Vingador vingadorAdversario = new Vingador("Joao",180, mjolnir, semTalento, posicaoDentro);

        String resultadoEsperado = "EMPATE";

        // act
        String resultadoReal = arena.batalhar(vingadorLocal, vingadorAdversario);

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }


    @Test
    public void deveVencerVingadorComMaisVidaAoFinalDaBatalhaQuandoBatalhar() {
        Arena arena = new Arena(10, 10);

        Mjolnir mjolnir = new Mjolnir();
        HabilidadeEspecial semTalento = new SemTalento();
        Posicao posicaoDentro = new Posicao(5, 5);
        Vingador vingadorLocal = new Vingador("Maria",100, mjolnir, semTalento, posicaoDentro);
        Vingador vingadorAdversario = new Vingador("Joao",100, mjolnir, semTalento, posicaoDentro);

        String resultadoEsperado = vingadorLocal.getNome();

        // act
        String resultadoReal = arena.batalhar(vingadorLocal, vingadorAdversario);

        // assert
        Assert.assertEquals(resultadoEsperado, resultadoReal);
    }
}
