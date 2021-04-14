package classes;

import excecoes.PersonagemJaEstaNoMapaException;
import excecoes.PersonagemNaoEncontradoNoMapaException;
import excecoes.PosicaoOcupadaException;
import mapas.Mapa;
import personagens.Personagem;

public abstract class Arqueiro extends Personagem {

    private static final int NUMERO_MAXIMO_DE_PASSOS = 2;

    private static final int DISTANCIA_MAXIMA_DE_ATAQUE = 3;

    public Arqueiro(String indicador, int forca, int agilidade, int inteligencia, int constituicao) {
        super(indicador, forca, agilidade, inteligencia, constituicao);
    }

    public void andar(Mapa mapa) throws PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException, PersonagemJaEstaNoMapaException {
        for (int passos = 1; passos <= NUMERO_MAXIMO_DE_PASSOS; passos++)
            mapa.moverPersonagem(this);
    }

    public void atacar(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException {
        Personagem alvo;
        int posicaoAlvo;

        for (int distanciaAtual = DISTANCIA_MAXIMA_DE_ATAQUE; distanciaAtual > 0; distanciaAtual--) {
            posicaoAlvo = mapa.buscarPosicaoRelativa(this, distanciaAtual);

            if (posicaoAlvo > -1) {

                alvo = mapa.buscarCasa(posicaoAlvo);

                if (alvo != null && !pertenceAoMesmoExercito(alvo)) {
                    alvo.receberDano(calcularDano(distanciaAtual));
                    break;
                }
            }
        }
    }

    private int calcularDano(int distancia) {
        return distancia * getAgilidade();
    }

}
