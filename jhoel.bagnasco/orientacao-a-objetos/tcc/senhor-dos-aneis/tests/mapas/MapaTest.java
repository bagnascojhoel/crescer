package mapas;

import excecoes.PersonagemJaEstaNoMapaException;
import excecoes.PersonagemNaoEncontradoNoMapaException;
import excecoes.PosicaoOcupadaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import personagens.Personagem;
import personagens.exercitodesauron.Goblim;
import personagens.exercitodesauron.Saruman;
import personagens.sociedadedoanel.Aragorn;
import personagens.sociedadedoanel.Gandalf;
import personagens.sociedadedoanel.Gimli;

public class MapaTest {

    private Mapa mapa;

    @Before
    public void preparar() {
        mapa = new Mapa();
    }

    @Test
    public void deveSerMapaVazioQuandoConstruido() {
        String mapaEsperado = "| | | | | | | | | | |";

        String mapaReal = mapa.exibir();

        Assert.assertEquals(mapaEsperado, mapaReal);
    }

    @Test
    public void deveContinuarMapaVazioQuandoInserirPersonagemMorto() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        Goblim goblim = new Goblim();
        goblim.receberDano(goblim.getConstituicao());
        String mapaEsperado = "| | | | | | | | | | |";

        // act
        mapa.inserir(3, goblim);
        String mapaReal = mapa.exibir();

        // assert
        Assert.assertEquals(mapaEsperado, mapaReal);
    }

    @Test
    public void deveTerAragornNaPosicaoZeroESarumanNaPosicaoNoveQuandoExibirAposInserirAmbos() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        Aragorn aragorn = new Aragorn();
        Saruman saruman = new Saruman();
        String mapaEsperado = "|A| | | | | | | | |S|";

        // act
        mapa.inserir(0, aragorn);
        mapa.inserir(9, saruman);
        String mapaReal = mapa.exibir();

        // assert
        Assert.assertEquals(mapaEsperado, mapaReal);
    }

    @Test(expected = PosicaoOcupadaException.class)
    public void deveLancarExcecaoPosicaoOcupadaQuandoInserirEmPosicaoOcupada() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        Aragorn aragorn = new Aragorn();
        Gandalf gandalf = new Gandalf();

        mapa.inserir(0, aragorn);
        mapa.inserir(0, gandalf);
    }

    @Test(expected = PersonagemJaEstaNoMapaException.class)
    public void deveLancarExcecaoPersonagemJaEstaNoMapaQuandoPersonagemJaEstiverNoMapa() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        Aragorn aragorn = new Aragorn();

        mapa.inserir(0, aragorn);
        mapa.inserir(1, aragorn);
    }

    @Test
    public void deveSerPosicaoOndeAragornSeEncontraQuandoBuscarPosicao() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Aragorn aragorn = new Aragorn();
        int posicao = 5;
        int posicaoEsperada = posicao;

        // act
        mapa.inserir(posicao, aragorn);
        int posicaoReal = mapa.buscarPosicao(aragorn);

        // assert
        Assert.assertEquals(posicaoEsperada, posicaoReal);
    }

    @Test(expected = PersonagemNaoEncontradoNoMapaException.class)
    public void deveLancarExcecaoPersonagemNaoEncontradoQuandoOPersonagemNaoEstiverNoMapa() throws PersonagemNaoEncontradoNoMapaException {
        Aragorn aragorn = new Aragorn();

        mapa.buscarPosicao(aragorn);
    }

    @Test
    public void deveSerUmPersonagemQuandoAPosicaoEstiverOcupada() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        Gimli gimli = new Gimli();
        int posicao = 3;
        Personagem personagemEsperado = gimli;

        // act
        mapa.inserir(posicao, gimli);
        Personagem personagemReal = mapa.buscarCasa(posicao);

        Assert.assertEquals(personagemEsperado, personagemReal);
    }

    @Test
    public void deveSerNuloQuandoPosicaoEstiverVazia() {
        Personagem personagemEsperado = null;

        Personagem personagemReal = mapa.buscarCasa(3);

        Assert.assertEquals(personagemEsperado, personagemReal);
    }

    @Test
    public void deveSerQuatroQuandoBuscarPosicaoRelativeDeMembroDaSociedadeDoAnelEmUmComDistanciaTres() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Gandalf gandalf = new Gandalf();
        mapa.inserir(1, gandalf);
        int posicaoEsperada = 4;

        int posicaoReal = mapa.buscarPosicaoRelativa(gandalf, 3);

        Assert.assertEquals(posicaoEsperada, posicaoReal);
    }

    @Test
    public void deveSerQuatroQuandoBuscarPosicaoRelativeDeMembroDoExercitoDeSauronEmOitoComDistanciaQuatro() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Saruman saruman = new Saruman();
        mapa.inserir(8, saruman);
        int posicaoEsperada = 4;

        int posicaoReal = mapa.buscarPosicaoRelativa(saruman, 4);

        Assert.assertEquals(posicaoEsperada, posicaoReal);
    }
}
