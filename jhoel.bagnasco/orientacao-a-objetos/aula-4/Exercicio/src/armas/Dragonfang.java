package armas;

import locais.Posicao;

public class Dragonfang extends Arma {
    private static final int DANO_BASE = 30;

    public Dragonfang() {
        super(Dragonfang.DANO_BASE);
    }

    @Override
    public int calcularDano(Posicao origem, Posicao destino) {
        int distancia = calcularDistancia(origem, destino);
        int danoQuandoDistante = 0;
        int danoQuandoProximo = getDanoBase() * 10;
        return (distancia > 5 ? danoQuandoDistante : danoQuandoProximo);
    }
}
