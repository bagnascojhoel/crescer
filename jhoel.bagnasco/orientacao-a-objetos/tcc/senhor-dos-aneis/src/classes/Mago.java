package classes;

import excecoes.PersonagemJaEstaNoMapaException;
import excecoes.PersonagemNaoEncontradoNoMapaException;
import excecoes.PosicaoOcupadaException;
import mapas.Mapa;
import personagens.Personagem;

public abstract class Mago extends Personagem {

    public Mago(String indicador, int forca, int agilidade, int inteligencia, int constituicao) {
        super(indicador, forca, agilidade, inteligencia, constituicao);
    }

    public void andar(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException, PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        for (Personagem p : mapa.getPosicoes())
            if (p != this && p != null) return;

        mapa.moverPersonagem(this);
    }

    public void atacar(Mapa mapa) {
        int dano = getInteligencia();

        for (Personagem alvo : mapa.getPosicoes())
            if (alvo != null && !pertenceAoMesmoExercito(alvo))
                alvo.receberDano(dano);
    }
}
