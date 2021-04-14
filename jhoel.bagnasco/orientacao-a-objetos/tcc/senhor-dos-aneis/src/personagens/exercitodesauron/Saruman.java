package personagens.exercitodesauron;

import classes.Mago;
import racas.Maia;

public class Saruman extends Mago implements Maia {

    private static final int FORCA = 2;

    private static final int AGILIDADE = 2;

    private static final int INTELIGENCIA = 9;

    private static final int CONSTITUICAO_INICIAL = 70;

    private static final String FALA = "Against the power of Mordor there can be no victory.";

    private static final String INDICADOR = "S";

    public Saruman() {
        super(INDICADOR, FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL);
    }

    @Override
    public String falar() {
        return FALA;
    }

    @Override
    public Saruman ressucitar() {
        return null;
    }

    @Override
    public boolean pertenceASociedadeDoAnel() {
        return false;
    }
}
