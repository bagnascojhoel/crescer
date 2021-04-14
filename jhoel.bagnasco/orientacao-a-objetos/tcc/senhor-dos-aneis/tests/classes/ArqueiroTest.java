package classes;

import excecoes.PersonagemJaEstaNoMapaException;
import excecoes.PersonagemNaoEncontradoNoMapaException;
import excecoes.PosicaoOcupadaException;
import mapas.Mapa;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import personagens.exercitodesauron.Goblim;
import personagens.exercitodesauron.Saruman;
import personagens.sociedadedoanel.Aragorn;
import personagens.sociedadedoanel.Gandalf;
import personagens.sociedadedoanel.Gimli;
import personagens.sociedadedoanel.Legolas;

public class ArqueiroTest {

    private Mapa mapa;
    private Arqueiro arqueiroMembroDaSociedadeDoAnel;
    private Arqueiro arqueiroMembroDoExercitoDeSaruman;

    @Before
    public void preparar() {
        mapa = new Mapa();
        arqueiroMembroDaSociedadeDoAnel = new Legolas();
        arqueiroMembroDoExercitoDeSaruman = new Goblim();
    }

    @Test
    public void deveMoverDuasCasasParaDireitaQuandoAndarEForMembroDaSociedadeDoAnel() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {

        mapa.inserir(0, arqueiroMembroDaSociedadeDoAnel);
        String mapaEsperado = "| | |L| | | | | | | |";
        ;

        // act
        arqueiroMembroDaSociedadeDoAnel.andar(mapa);
        String mapaReal = mapa.exibir();

        // assert
        Assert.assertEquals(mapaEsperado, mapaReal);
    }

    @Test
    public void deveMoverUmaCasaParaDireitaQuandoAndarEForMembroDaSociedadeDoAnelComApenasUmaProximaCasaLivre() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {

        Gandalf gandalf = new Gandalf();

        mapa.inserir(0, arqueiroMembroDaSociedadeDoAnel);
        mapa.inserir(2, gandalf);
        String mapaEsperado = "| |L|G| | | | | | | |";
        ;

        // act
        arqueiroMembroDaSociedadeDoAnel.andar(mapa);
        String mapaReal = mapa.exibir();

        // assert
        Assert.assertEquals(mapaEsperado, mapaReal);
    }

    @Test
    public void deveMoverDuasCasasParaEsquerdaQuandoAndarEForMembroDoExercitoDeSaruman() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {

        mapa.inserir(9, arqueiroMembroDoExercitoDeSaruman);
        String mapaEsperado = "| | | | | | | |M| | |";
        ;

        // act
        arqueiroMembroDoExercitoDeSaruman.andar(mapa);
        String mapaReal = mapa.exibir();

        // assert
        Assert.assertEquals(mapaEsperado, mapaReal);
    }

    @Test
    public void deveMoverUmaCasaParaEsquerdaQuandoAndarEForMembroDoExercitoDeSarumanComApenasUmaProximaCasaLivre() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Gandalf gandalf = new Gandalf();

        mapa.inserir(9, arqueiroMembroDoExercitoDeSaruman);
        mapa.inserir(7, gandalf);
        String mapaEsperado = "| | | | | | | |G|M| |";
        ;

        // act
        arqueiroMembroDoExercitoDeSaruman.andar(mapa);
        String mapaReal = mapa.exibir();

        // assert
        Assert.assertEquals(mapaEsperado, mapaReal);
    }

    @Test
    public void deveNaoMoverQuandoAndarEExistirUmPersonagemNaProximaPosicaoAEsquerdaEForMembroDoExercitoDeSaruman() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Legolas legolas = new Legolas();

        mapa.inserir(9, arqueiroMembroDoExercitoDeSaruman);
        mapa.inserir(8, legolas);
        String mapaEsperado = mapa.exibir();

        // act
        arqueiroMembroDoExercitoDeSaruman.andar(mapa);
        String mapaReal = mapa.exibir();

        // assert
        Assert.assertEquals(mapaEsperado, mapaReal);
    }

    @Test
    public void deveNaoMoverQuandoAndarEExistirUmPersonagemNaProximaPosicaoADireitaEForMembroDaSociedadeDoAnel() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Goblim goblim = new Goblim();

        mapa.inserir(8, goblim);
        mapa.inserir(7, arqueiroMembroDaSociedadeDoAnel);
        String mapaEsperado = mapa.exibir();

        // act
        arqueiroMembroDaSociedadeDoAnel.andar(mapa);
        String mapaReal = mapa.exibir();

        // assert
        Assert.assertEquals(mapaEsperado, mapaReal);
    }

    @Test
    public void deveCausarTresVezesSuaAgilidadeComoDanoQuandoAtacarMembroDoExercitoDeSarumanNaTerceiraPosicaoADireitaENaoForMembroDela() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Goblim goblim = new Goblim();

        mapa.inserir(0, arqueiroMembroDaSociedadeDoAnel);
        mapa.inserir(3, goblim);
        int danoASerRecebido = 3 * arqueiroMembroDaSociedadeDoAnel.getAgilidade();
        int constituicaoEsperada = danoASerRecebido > goblim.getConstituicao() ? 0 : goblim.getConstituicao() - danoASerRecebido;

        // act
        arqueiroMembroDaSociedadeDoAnel.atacar(mapa);
        int constituicaoReal = goblim.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveCausarDobroDeSuaAgilidadeComoDanoQuandoAtacarMembroDoExercitoDeSarumanNaSegundaPosicaoADireitaENaoForMembroDela() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Goblim goblim = new Goblim();

        mapa.inserir(0, arqueiroMembroDaSociedadeDoAnel);
        mapa.inserir(2, goblim);
        int danoASerRecebido = 2 * arqueiroMembroDaSociedadeDoAnel.getAgilidade();
        int constituicaoEsperada = danoASerRecebido > goblim.getConstituicao() ? 0 : goblim.getConstituicao() - danoASerRecebido;

        // act
        arqueiroMembroDaSociedadeDoAnel.atacar(mapa);
        int constituicaoReal = goblim.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveCausarSuaAgilidadeComoDanoQuandoAtacarMembroDoExercitoDeSarumanNaProximaPosicaoADireitaENaoForMembroDela() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Goblim goblim = new Goblim();

        mapa.inserir(0, arqueiroMembroDaSociedadeDoAnel);
        mapa.inserir(1, goblim);
        int danoASerRecebido = arqueiroMembroDaSociedadeDoAnel.getAgilidade();
        int constituicaoEsperada = danoASerRecebido > goblim.getConstituicao() ? 0 : goblim.getConstituicao() - danoASerRecebido;

        // act
        arqueiroMembroDaSociedadeDoAnel.atacar(mapa);
        int constituicaoReal = goblim.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveCausarTresVezesSuaAgilidadeComoDanoQuandoAtacarMembroDaSociedadeDoAnelNaTerceiraPosicaoAEsquerdaENaoForMembroDela() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Gandalf gandalf = new Gandalf();

        mapa.inserir(9, arqueiroMembroDoExercitoDeSaruman);
        mapa.inserir(6, gandalf);
        int danoASerRecebido = 3 * arqueiroMembroDoExercitoDeSaruman.getAgilidade();
        int constituicaoEsperada = danoASerRecebido > gandalf.getConstituicao() ? 0 : gandalf.getConstituicao() - danoASerRecebido;

        // act
        arqueiroMembroDoExercitoDeSaruman.atacar(mapa);
        int constituicaoReal = gandalf.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveCausarDobroDeSuaAgilidadeComoDanoQuandoAtacarMembroDaSociedadeDoAnelNaSegundaPosicaoAEsquerdaENaoForMembroDela() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Gandalf gandalf = new Gandalf();

        mapa.inserir(9, arqueiroMembroDoExercitoDeSaruman);
        mapa.inserir(7, gandalf);
        int danoASerRecebido = 2 * arqueiroMembroDoExercitoDeSaruman.getAgilidade();
        int constituicaoEsperada = danoASerRecebido > gandalf.getConstituicao() ? 0 : gandalf.getConstituicao() - danoASerRecebido;

        // act
        arqueiroMembroDoExercitoDeSaruman.atacar(mapa);
        int constituicaoReal = gandalf.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveCausarSuaAgilidadeComoDanoQuandoAtacarMembroDaSociedadeDoAnelNaProximaPosicaoAEsquerdaENaoForMembroDela() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Gandalf gandalf = new Gandalf();

        mapa.inserir(9, arqueiroMembroDoExercitoDeSaruman);
        mapa.inserir(8, gandalf);
        int danoASerRecebido = arqueiroMembroDoExercitoDeSaruman.getAgilidade();
        int constituicaoEsperada = danoASerRecebido > gandalf.getConstituicao() ? 0 : gandalf.getConstituicao() - danoASerRecebido;

        // act
        arqueiroMembroDoExercitoDeSaruman.atacar(mapa);
        int constituicaoReal = gandalf.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveCausarDanoAoInimigoMaisDistanteAteTresCasasADireitaQuandoAtacarEForMembroDaSociedadeDoAnel() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Goblim goblim = new Goblim();
        Saruman saruman = new Saruman();

        mapa.inserir(0, arqueiroMembroDaSociedadeDoAnel);
        mapa.inserir(1, goblim);
        mapa.inserir(3, saruman);
        int danoASerRecebido = 3 * arqueiroMembroDaSociedadeDoAnel.getAgilidade();
        int constituicaoEsperadaSaruman = danoASerRecebido > saruman.getConstituicao() ? 0 : saruman.getConstituicao() - danoASerRecebido;
        int constituicaoEsperadaGoblim = goblim.getConstituicao();

        // act
        arqueiroMembroDaSociedadeDoAnel.atacar(mapa);
        int constituicaoRealSaruman = saruman.getConstituicao();
        int constituicaoRealGoblim = goblim.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperadaSaruman, constituicaoRealSaruman);
        Assert.assertEquals(constituicaoEsperadaGoblim, constituicaoRealGoblim);
    }

    @Test
    public void deveCausarDanoAoInimigoMaisDistanteAteTresCasasAEsquerdaQuandoAtacarEForMembroDoExercitoDeSaruman() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException {
        Aragorn aragorn = new Aragorn();
        Gimli gimli = new Gimli();

        mapa.inserir(9, arqueiroMembroDoExercitoDeSaruman);
        mapa.inserir(8, aragorn);
        mapa.inserir(6, gimli);
        int danoASerRecebido = 3 * arqueiroMembroDoExercitoDeSaruman.getAgilidade();
        int constituicaoEsperadaGimli = danoASerRecebido > gimli.getConstituicao() ? 0 : gimli.getConstituicao() - danoASerRecebido;
        int constituicaoEsperadaAragorn = aragorn.getConstituicao();

        // act
        arqueiroMembroDoExercitoDeSaruman.atacar(mapa);
        int constituicaoRealGimli = gimli.getConstituicao();
        int constituicaoRealAragorn = aragorn.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperadaGimli, constituicaoRealGimli);
        Assert.assertEquals(constituicaoEsperadaAragorn, constituicaoRealAragorn);
    }
}
