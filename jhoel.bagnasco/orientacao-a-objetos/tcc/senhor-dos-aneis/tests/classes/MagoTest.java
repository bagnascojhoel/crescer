package classes;

import excecoes.PersonagemJaEstaNoMapaException;
import excecoes.PersonagemNaoEncontradoNoMapaException;
import excecoes.PosicaoOcupadaException;
import mapas.Mapa;
import org.junit.Assert;
import org.junit.Test;
import personagens.exercitodesauron.Saruman;
import personagens.exercitodesauron.Urukhai;
import personagens.sociedadedoanel.Gandalf;
import personagens.sociedadedoanel.Legolas;

public class MagoTest {

    @Test
    public void deveMoverUmaPosicaoParaDireitaQuandoAndarEForMembroDaSociedadeDoAnelComMapaVazio() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Mago gandalf = new Gandalf();
        Mapa mapa = new Mapa();

        mapa.inserir(0, gandalf);

        String mapaEsperado = "| |G| | | | | | | | |";

        // act
        gandalf.andar(mapa);
        String mapaReal = mapa.exibir();

        // assert
        Assert.assertEquals(mapaEsperado, mapaReal);
    }

    @Test
    public void deveMoverUmaPosicaoParaEsquerdaQuandoAndarEForMembroDoExercitoDeSarumanComMapaVazio() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Mago saruman = new Saruman();
        Mapa mapa = new Mapa();

        mapa.inserir(9, saruman);

        String mapaEsperado = "| | | | | | | | |S| |";

        // act
        saruman.andar(mapa);
        String mapaReal = mapa.exibir();

        // assert
        Assert.assertEquals(mapaEsperado, mapaReal);
    }

    @Test
    public void deveNaoMoverQuandoAndarEExisteOutroPersonagemNoMapa() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Mago gandalf = new Gandalf();
        Saruman saruman = new Saruman();
        Mapa mapa = new Mapa();

        mapa.inserir(0, gandalf);
        mapa.inserir(9, saruman);

        String mapaEsperado = mapa.exibir();

        // act
        gandalf.andar(mapa);
        saruman.andar(mapa);
        String mapaReal = mapa.exibir();

        // assert
        Assert.assertEquals(mapaEsperado, mapaReal);
    }

    @Test
    public void deveNaoCausarDanoAMembrosDaSociedadeDoAnelQuandoAtacarEForTambemMembro() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        Mago gandalf = new Gandalf();
        Legolas legolas = new Legolas();
        Mapa mapa = new Mapa();

        mapa.inserir(0, gandalf);
        mapa.inserir(4, legolas);
        int constituicaoEsperada = legolas.getConstituicao();

        // act
        gandalf.atacar(mapa);
        int constituicaoReal = legolas.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveCausarSuaInteligenciaEmDanoATodosMembrosDoExercitoDeSarumanQuandoAtacarENaoForMembro() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        Mago gandalf = new Gandalf();
        Saruman saruman = new Saruman();
        Urukhai urukhai = new Urukhai();
        Mapa mapa = new Mapa();

        mapa.inserir(0, gandalf);
        mapa.inserir(4, saruman);
        mapa.inserir(6, urukhai);
        int constituicaoEsperadaSaruman = saruman.getConstituicao() - gandalf.getInteligencia();
        int constituicaoEsperadaUrukhai = urukhai.getConstituicao() - gandalf.getInteligencia();

        // act
        gandalf.atacar(mapa);
        int constituicaoRealSaruman = saruman.getConstituicao();
        int constituicaoRealUrukhai = urukhai.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperadaSaruman, constituicaoRealSaruman);
        Assert.assertEquals(constituicaoEsperadaUrukhai, constituicaoRealUrukhai);
    }
}
