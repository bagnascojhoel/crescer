package personagens;

import excecoes.PersonagemJaEstaNoMapaException;
import excecoes.PersonagemNaoEncontradoNoMapaException;
import excecoes.PosicaoOcupadaException;
import mapas.Mapa;

public abstract class Personagem implements ParticipanteDaGuerra {

    private final String indicador;

    private final int forca;

    private final int agilidade;

    private final int inteligencia;

    private int constituicao;

    public Personagem(String indicador, int forca, int agilidade, int inteligencia, int constituicao) {
        this.indicador = indicador;
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.constituicao = constituicao;
    }

    public int receberDano(int danoAReceber) {
        int danoRecebido = danoAReceber > constituicao ? constituicao : danoAReceber;

        if (estaVivo())
            constituicao -= danoRecebido;

        return danoRecebido;
    }

    public boolean pertenceAoMesmoExercito(ParticipanteDaGuerra alvo) {
        return pertenceASociedadeDoAnel() == alvo.pertenceASociedadeDoAnel();
    }

    public String toString() {
        return indicador;
    }

    public boolean estaVivo() {
        return constituicao > 0;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public int getForca() {
        return forca;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public abstract void atacar(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException;

    public abstract void andar(Mapa mapa) throws PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException, PersonagemJaEstaNoMapaException;
}
