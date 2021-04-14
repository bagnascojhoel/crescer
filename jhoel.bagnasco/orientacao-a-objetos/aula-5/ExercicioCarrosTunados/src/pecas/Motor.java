package pecas;

public class Motor extends Peca {
    private static final int VELOCIDADE_DE_DESGASTE = 1;

    public Motor(int qualidade) {
        super(qualidade, VELOCIDADE_DE_DESGASTE);
    }
}
