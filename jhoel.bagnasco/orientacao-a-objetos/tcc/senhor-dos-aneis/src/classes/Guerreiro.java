package classes;

import excecoes.PersonagemJaEstaNoMapaException;
import excecoes.PersonagemNaoEncontradoNoMapaException;
import excecoes.PosicaoOcupadaException;
import mapas.Mapa;
import personagens.Personagem;

public abstract class Guerreiro extends Personagem {

    private static final int MULTIPLICADOR_FORCA = 2;

    public Guerreiro(String indicador, int forca, int agilidade, int inteligencia, int constituicao) {
        super(indicador, forca, agilidade, inteligencia, constituicao);
    }

    public void andar(Mapa mapa) throws PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException, PersonagemJaEstaNoMapaException {
        mapa.moverPersonagem(this);
    }

    public void atacar(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException {
        int dano = MULTIPLICADOR_FORCA * getForca();
        int posicaoAlvo = mapa.buscarPosicaoRelativa(this, 1);
        Personagem alvo = mapa.buscarCasa(posicaoAlvo);

        if (alvo == null || pertenceAoMesmoExercito(alvo)) return;

        alvo.receberDano(dano);
    }

}
