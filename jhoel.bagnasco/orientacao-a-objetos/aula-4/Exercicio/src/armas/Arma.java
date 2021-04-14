package armas;

import locais.Posicao;

public abstract class Arma {

    private int dano;

    public Arma(int dano) {
        this.dano = dano;
    }

    public int calcularDano(Posicao origem, Posicao destino) {
        return this.getDanoBase();
    };

    protected int getDanoBase() {
        return this.dano;
    }

    protected static int calcularDistancia(Posicao pos1, Posicao pos2) {
        double largura = Math.pow(pos1.getX() - pos2.getX(), 2);
        double altura = Math.pow(pos1.getY() - pos2.getY(), 2);

        long distancia = Math.round(Math.sqrt(largura + altura));
        return Math.toIntExact(distancia);
    }
}
