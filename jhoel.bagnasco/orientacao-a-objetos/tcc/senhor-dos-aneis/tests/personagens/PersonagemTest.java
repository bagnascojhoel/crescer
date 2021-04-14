package personagens;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import personagens.sociedadedoanel.Gimli;

public class PersonagemTest {

    private Personagem personagem;

    @Before
    public void preparar() {
        personagem = new Gimli();
    }

    @Test
    public void deveDiminuirAConstituicaoQuandoReceberDano() {
        int dano = 10;
        int constituicaoAtual = personagem.getConstituicao();
        int constituicaoEsperada = constituicaoAtual - dano;

        // act
        personagem.receberDano(dano);
        int constituicaoReal = personagem.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveTerConstituicaoIgualZeroQuandoReceberDanoMaiorQueSuaConstituicao() {
        int constituicaoAtual = personagem.getConstituicao();
        int constituicaoEsperada = 0;

        // act
        personagem.receberDano(constituicaoAtual + 1);
        int constituicaoReal = personagem.getConstituicao();

        // assert
        Assert.assertEquals(constituicaoEsperada, constituicaoReal);
    }

    @Test
    public void deveSerVerdadeiroQuandoConstituicaoMaiorQueZero() {
        boolean resultado = personagem.estaVivo();

        Assert.assertTrue(resultado);
    }

    @Test
    public void deveSerFalsoQuandoConstituicaoIgualZero() {
        int dano = personagem.getConstituicao();

        // act
        personagem.receberDano(dano);
        boolean resultado = personagem.estaVivo();

        // assert
        Assert.assertFalse(resultado);
    }

    @Test
    public void deveSeMovimentarParaDireitaQuandoPersonagemEMembroDaSociedadeDoAnel() {
    }

    @Test
    public void deveSeMovimentarParaEsquerdaQuandoPersonagemEMembroDoExercitoDeSaruman() {
    }

    @Test
    public void deveNaoAtacarMembrosDaSociedadeDoAnelQuandoTambemEMembro() {
    }

    @Test
    public void deveNaoAtacarMembrosDoExercitoDeSarumanQuandoTambemEMembro() {
    }

}
