package classes;

import excecoes.PersonagemJaEstaNoMapaException;
import excecoes.PersonagemNaoEncontradoNoMapaException;
import excecoes.PosicaoOcupadaException;
import mapas.Mapa;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import personagens.exercitodesauron.Orc;
import personagens.exercitodesauron.Saruman;
import personagens.exercitodesauron.Urukhai;
import personagens.sociedadedoanel.Aragorn;
import personagens.sociedadedoanel.Gandalf;

public class GuerreiroTest {

    private Mapa mapa;

    @Before
    public void preparar() {
        mapa = new Mapa();
    }

    @Test
    public void deveAndarUmaCasaParaDireitaQuandoAndarMembroDaSociedadeDoAnelComProximaPosicaoVazia() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Guerreiro guerreiro = new Aragorn();

        mapa.inserir(0, guerreiro);
        String mapaEsperado = "| |A| | | | | | | | |";

        // act
        guerreiro.andar(mapa);
        String mapaReal = mapa.exibir();

        // assert
        Assert.assertEquals(mapaEsperado, mapaReal);
    }

    @Test
    public void deveAndarUmaCasaParaEsquerdaQuandoAndarMembroDoExercitoDeSarumanComProximaPosicaoVazia() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Guerreiro guerreiro = new Urukhai();

        mapa.inserir(7, guerreiro);
        String mapaEsperado = "| | | | | | |U| | | |";
        ;

        // act
        guerreiro.andar(mapa);
        String mapaReal = mapa.exibir();

        // assert
        Assert.assertEquals(mapaEsperado, mapaReal);
    }

    @Test
    public void deveNaoMoverQuandoAndarComProximaPosicaoADireitaOcupadaEForMembroDaSociedadeDoAnel() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Guerreiro guerreiro = new Aragorn();
        Gandalf gandalf = new Gandalf();

        mapa.inserir(0, guerreiro);
        mapa.inserir(1, gandalf);
        String mapaEsperado = mapa.exibir();

        // act
        guerreiro.andar(mapa);
        String mapaReal = mapa.exibir();

        // assert
        Assert.assertEquals(mapaEsperado, mapaReal);
    }

    @Test
    public void deveNaoMoverQuandoAndarComProximaPosicaoAEsquerdaOcupadaEForMembroDoExercitoDeSaruman() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Guerreiro guerreiro = new Urukhai();
        Gandalf gandalf = new Gandalf();

        mapa.inserir(9, guerreiro);
        mapa.inserir(8, gandalf);
        String mapaEsperado = mapa.exibir();

        // act
        guerreiro.andar(mapa);
        String mapaReal = mapa.exibir();

        // assert
        Assert.assertEquals(mapaEsperado, mapaReal);
    }

    @Test
    public void deveNaoCausarDanoQuandoAtacarMembroDoExercitoDeSarumanNaProximaPosicaoEsquerdaEForDele() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Guerreiro urukhai = new Urukhai();
        Saruman saruman = new Saruman();
        mapa.inserir(0, saruman);
        mapa.inserir(9, urukhai);
        int constituicaoEsperada = saruman.getConstituicao();

        // act
        urukhai.atacar(mapa);
        int constituicaoReal = saruman.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveCausarDobroDaForcaComoDanoAMembroDoExercitoDeSarumanNaProximaPosicaoADireitaQuandoAtacarEForMembroDaSociedadeDoAnel() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Guerreiro aragorn = new Aragorn();
        Urukhai urukhai = new Urukhai();
        mapa.inserir(0, aragorn);
        mapa.inserir(1, urukhai);
        int constituicaoEsperada = urukhai.getConstituicao() - 2 * aragorn.getForca();

        // act
        aragorn.atacar(mapa);
        int constituicaoReal = urukhai.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveNaoCausarDanoAMembroDaSociedadeDoAnelNaProximaPosicaoADireitaQuandoAtacarEForMembroDaSociedadeDoAnel() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Guerreiro aragorn = new Aragorn();
        Gandalf gandalf = new Gandalf();
        mapa.inserir(0, aragorn);
        mapa.inserir(1, gandalf);
        int constituicaoEsperada = gandalf.getConstituicao();

        // act
        aragorn.atacar(mapa);
        int constituicaoReal = gandalf.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveNaoCausarDanoAPersonagensNaEsquerdaQuandoAtacarEForMembroDaSociedadeDoAnel() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Guerreiro aragorn = new Aragorn();
        Urukhai urukhai = new Urukhai();
        mapa.inserir(2, aragorn);
        mapa.inserir(0, urukhai);
        int constituicaoEsperada = urukhai.getConstituicao();

        // act
        aragorn.atacar(mapa);
        int constituicaoReal = urukhai.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveNaoCausarDanoAMembrosDoExercitoDeSarumanMaisDistantesQueUmaCasaQuandoAtacarEForMembroDaSociedadeDoAnel() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Guerreiro aragorn = new Aragorn();
        Urukhai urukhai = new Urukhai();
        mapa.inserir(0, aragorn);
        mapa.inserir(2, urukhai);
        int constituicaoEsperada = urukhai.getConstituicao();

        // act
        aragorn.atacar(mapa);
        int constituicaoReal = urukhai.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveNaoCausarDanoAPersonagensNaDireitaQuandoAtacarEForMembroDoExercitoDeSaruman() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Guerreiro urukhai = new Urukhai();
        Aragorn aragorn = new Aragorn();
        mapa.inserir(2, aragorn);
        mapa.inserir(1, urukhai);
        int constituicaoEsperada = aragorn.getConstituicao();

        // act
        urukhai.atacar(mapa);
        int constituicaoReal = aragorn.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveCausarDobroDaForcaComoDanoAMembroDaSociedadeDoAnelNaProximaPosicaoAEsquerdaQuandoAtacarEForMembroDoExercitoDeSaruman() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Guerreiro orc = new Orc();
        Gandalf gandalf = new Gandalf();
        mapa.inserir(9, orc);
        mapa.inserir(8, gandalf);
        int constituicaoEsperada = gandalf.getConstituicao() - 2 * orc.getForca();

        // act
        orc.atacar(mapa);
        int constituicaoReal = gandalf.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveNaoCausarDanoAMembroDoExercitoDeSarumanNaProximaPosicaoAEsquerdaQuandoAtacarEForMembroDoExercitoDeSaruman() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Guerreiro orc = new Orc();
        Urukhai urukhai = new Urukhai();
        mapa.inserir(2, orc);
        mapa.inserir(1, urukhai);
        int constituicaoEsperada = urukhai.getConstituicao();

        // act
        orc.atacar(mapa);
        int constituicaoReal = urukhai.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveNaoCausarDanoAMembrosDaSociedadeDoAnelMaisDistantesQueUmaCasaQuandoAtacarEForMembroDoExercitoDeSaruman() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Guerreiro orc = new Orc();
        Gandalf gandalf = new Gandalf();
        mapa.inserir(9, orc);
        mapa.inserir(1, gandalf);
        int constituicaoEsperada = gandalf.getConstituicao();

        // act
        orc.atacar(mapa);
        int constituicaoReal = gandalf.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }
}
