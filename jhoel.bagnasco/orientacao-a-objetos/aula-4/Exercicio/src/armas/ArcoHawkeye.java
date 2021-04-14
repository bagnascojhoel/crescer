package armas;

import locais.Posicao;

public class ArcoHawkeye extends Arma {
    private static final int DANO_BASE = 10;

    public ArcoHawkeye() {
        super(ArcoHawkeye.DANO_BASE);
    }

    @Override
    public int calcularDano(Posicao origem, Posicao destino) {
        int distancia = this.calcularDistancia(origem, destino);
        int danoQuandoProximo = 0;
        int danoQuandoNaAreaDeAtaque = this.getDanoBase() * (distancia / 100);
        int danoQuandoLonge = this.getDanoBase() * 10;

        if (distancia < 100) return danoQuandoProximo;
        if (distancia >= 100 && distancia <= 500) return danoQuandoNaAreaDeAtaque;
        else return danoQuandoLonge;
    }
}
