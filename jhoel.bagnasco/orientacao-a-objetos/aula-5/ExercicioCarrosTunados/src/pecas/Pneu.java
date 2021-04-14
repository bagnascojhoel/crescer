package pecas;

public class Pneu extends Peca {
    private static final int VELOCIDADE_DE_DESGASTE = 3;

    public Pneu(int qualidade) {
        super(qualidade, VELOCIDADE_DE_DESGASTE);
    }
}
