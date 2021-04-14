package megazord;

import megazord.battlemode.parts.*;

public class MegazordBattleMode implements Megazord {

    private Cabeca cabeca;

    private Peito peito;

    private Braco bracos;

    private PernaEsquerda pernaEsquerda;

    private PernaDireita pernaDireita;

    public MegazordBattleMode(
            Cabeca cabeca,
            Peito peito,
            Braco bracos,
            PernaEsquerda pernaEsquerda,
            PernaDireita pernaDireita) {

        this.cabeca = cabeca;
        this.peito = peito;
        this.bracos = bracos;
        this.pernaEsquerda = pernaEsquerda;
        this.pernaDireita = pernaDireita;
    }

    @Override
    public int getComprimento() {
        return (this.pernaDireita.getComprimento() + this.pernaEsquerda.getComprimento()) /2;
    }

    @Override
    public int getAltura() {
        int alturaPernas = (this.pernaEsquerda.getAltura() + this.pernaDireita.getAltura()) / 2;
        return this.cabeca.getAltura() + this.peito.getAltura() + alturaPernas;
    }

    @Override
    public int getPeso() {
        return this.cabeca.getPeso()
                + this.peito.getPeso()
                + this.bracos.getPeso()
                + this.pernaEsquerda.getPeso()
                + this.pernaDireita.getPeso();
    }

    @Override
    public int getVelocidade() {
        return (this.pernaEsquerda.getVelocidade() + this.pernaDireita.getVelocidade()) /3;
    }
}
