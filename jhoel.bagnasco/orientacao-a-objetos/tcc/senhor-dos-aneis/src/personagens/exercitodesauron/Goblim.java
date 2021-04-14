package personagens.exercitodesauron;

import classes.Arqueiro;
import racas.Monstro;

public class Goblim extends Arqueiro implements Monstro {

    private static final int FORCA = 3;

    private static final int AGILIDADE = 6;

    private static final int INTELIGENCIA = 1;

    private static final int CONSTITUICAO_INICIAL = 20;

    private static final String GRUNHIDO = "Iiisshhhh";

    private static final String INDICADOR = "M";

    public Goblim() {
        super(INDICADOR, FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL);
    }

    @Override
    public String grunir() {
        return GRUNHIDO;
    }

    @Override
    public boolean pertenceASociedadeDoAnel() {
        return false;
    }
}
