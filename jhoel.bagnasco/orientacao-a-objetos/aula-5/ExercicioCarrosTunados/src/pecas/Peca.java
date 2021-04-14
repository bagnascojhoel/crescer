package pecas;

import trajetos.Trajeto;

public abstract class Peca {

    private static final int PECA_ESTRAGADA = 0;

    private final int velocidadeDeDesgaste;

    public int qualidade;

    public Peca(int qualidade, int velocidadeDeDesgaste) {
        this.qualidade = qualidade;
        this.velocidadeDeDesgaste = velocidadeDeDesgaste;
    }

    public int usarNoTrajeto(Trajeto trajeto) {
        int possivelQualidade = qualidade - trajeto.dificuldade * this.velocidadeDeDesgaste;
        this.qualidade = Math.max(possivelQualidade, PECA_ESTRAGADA);

        return this.qualidade;
    }

    public boolean estaEstragada() {
        return this.qualidade == 0;
    }

}
