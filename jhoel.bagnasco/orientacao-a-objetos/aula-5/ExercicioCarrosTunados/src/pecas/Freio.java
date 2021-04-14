package pecas;

public class Freio extends Peca {
    private static final int VELOCIDADE_DE_DESGASTE = 2;

    public Freio(int qualidade) {
        super(qualidade, VELOCIDADE_DE_DESGASTE);
    }
}
