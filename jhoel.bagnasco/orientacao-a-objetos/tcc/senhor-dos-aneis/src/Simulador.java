import excecoes.PersonagemJaEstaNoMapaException;
import excecoes.PersonagemNaoEncontradoNoMapaException;
import excecoes.PosicaoOcupadaException;
import excecoes.SauronDominaOMundoException;
import mapas.Mapa;
import personagens.Personagem;

import java.util.ArrayList;
import java.util.List;

public class Simulador {

    private static final int POSICAO_VITORIA_SOCIEDADE_DO_ANEL = 9;

    private final Mapa mapa;

    public Simulador(Mapa mapa) {
        this.mapa = mapa;
    }

    public void simular() throws PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException, PersonagemJaEstaNoMapaException, SauronDominaOMundoException {


        while (!sociedadeDoAnelVencer() && !sauronVencer())
            executarRodada();

        if (sauronVencer())
            throw new SauronDominaOMundoException();
    }

    private void executarRodada() throws PersonagemNaoEncontradoNoMapaException, PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        List<Personagem> mapaDaRodada = new ArrayList<>(mapa.getPosicoes());

        for (Personagem p : mapaDaRodada)
            if (p != null && p.estaVivo()) {

                p.atacar(mapa);
                p.andar(mapa);
                removerCadaveres();
            }

    }

    private void removerCadaveres() throws PersonagemNaoEncontradoNoMapaException {
        for (Personagem p : mapa.getPosicoes())
            if (p != null && !p.estaVivo())
                removerCadaver(p);
    }

    private void removerCadaver(Personagem personagem) throws PersonagemNaoEncontradoNoMapaException {
        int posicaoARemover = mapa.buscarPosicao(personagem);
        mapa.remover(posicaoARemover);
    }

    private boolean sociedadeDoAnelVencer() {
        Personagem possivelVencedor = mapa.buscarCasa(POSICAO_VITORIA_SOCIEDADE_DO_ANEL);
        return (possivelVencedor != null) && possivelVencedor.pertenceASociedadeDoAnel();
    }

    private boolean sauronVencer() {

        for (Personagem p : mapa.getPosicoes())
            if (p != null && p.pertenceASociedadeDoAnel())
                return false;

        return true;
    }

}
